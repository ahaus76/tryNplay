package com.example.demo.elastic;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

public class CommerceDataForm extends FormLayout {


    TextField customer_first_name = new TextField("First name");
    TextField category = new TextField("Category");
    Binder<CommerceData> binder = new BeanValidationBinder(CommerceData.class);
    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    private CommerceData commerceData;
    private CommerceDataService commerceDataService;

    public CommerceDataForm(CommerceDataService commerceDataService) {
        this.commerceDataService = commerceDataService;

        binder.bindInstanceFields(this);

        add(customer_first_name, category);
        add(createButtonsLayout());
    }

    public CommerceData getCommerceData() {
        return commerceData;
    }

    public void setCommerceData(CommerceData commerceData) {
        this.commerceData = commerceData;
        binder.readBean(commerceData);
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        //save.addClickListener(event -> validateAndSave());
        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, commerceData)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));


        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(commerceData);
            fireEvent(new SaveEvent(this, commerceData));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

    // Events
    public abstract static class ContactFormEvent extends ComponentEvent<CommerceDataForm> {
        private final CommerceData commerceData;

        protected ContactFormEvent(CommerceDataForm source, CommerceData commerceData) {
            super(source, false);
            this.commerceData = commerceData;
        }

        public CommerceData getCommerceData() {
            return commerceData;
        }
    }

    public static class SaveEvent extends ContactFormEvent {
        SaveEvent(CommerceDataForm source, CommerceData commerceData) {
            super(source, commerceData);
        }
    }

    public static class DeleteEvent extends ContactFormEvent {
        DeleteEvent(CommerceDataForm source, CommerceData commerceData) {
            super(source, commerceData);
        }

    }

    public static class CloseEvent extends ContactFormEvent {
        CloseEvent(CommerceDataForm source) {
            super(source, null);
        }
    }
}


