package com.example.demo;

import com.example.demo.elastic.CommerceData;
import com.example.demo.elastic.CommerceDataService;
import com.example.demo.elastic.CommerceDataForm;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

@Route("view")
public class MainView extends VerticalLayout {

    private CommerceDataService commerceDataService;


	public MainView(CommerceDataService commerceDataService) {

        this.commerceDataService = commerceDataService;


        // Define Labels
		add(new H1("Bestellen"));
        add(new Text("Home/Produkte/Bestellen"));

        // Show main data
        Grid<CommerceData> dataGrid = prepareGrid();
        dataGrid.setItems( (commerceDataService.findAll()));
        add(dataGrid);

        // Show the Form to delete, save
        add(new CommerceDataForm(commerceDataService));

	}

    private Grid<CommerceData> prepareGrid() {
        Grid<CommerceData> dataGrid = new Grid<>(CommerceData.class);
        dataGrid.addContextMenu();
        dataGrid.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);

        return dataGrid;
    }

}
