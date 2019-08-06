package netcracker.homework.testTask.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import netcracker.homework.testTask.dto.ClientDto;

import java.util.List;
import java.util.logging.Logger;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class module implements EntryPoint {


    private CellTable<ClientDto> table = new CellTable<>();
    private Logger logger = Logger.getLogger("NameOfYourLogger");
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
    private final TextBox name = new TextBox();
    private final TextBox sureName = new TextBox();
    private final TextBox gender = new TextBox();
    private final TextBox age = new TextBox();

    private int id = -1;




    private ListDataProvider<ClientDto> createTable(CellTable<ClientDto> table){

        TextColumn<ClientDto> nameColumn = new TextColumn<ClientDto>() {
            @Override
            public String getValue(ClientDto ClientDto) {
                return ClientDto.getName();
            }
        };
        TextColumn<ClientDto> sureNameColumn = new TextColumn<ClientDto>() {
            @Override
            public String getValue(ClientDto clientDto) {
                return clientDto.getSureName();
            }
        };
        TextColumn<ClientDto> genderColumn = new TextColumn<ClientDto>() {
            @Override
            public String getValue(ClientDto clientDto) {
                return clientDto.getGender();
            }
        };
        TextColumn<ClientDto> ageColumn = new TextColumn<ClientDto>() {
            @Override
            public String getValue(ClientDto clientDto) {
                return String.valueOf(clientDto.getAge());
            }
        };


        table.addColumn(nameColumn, "Name");
        table.addColumn(sureNameColumn,"Surname");
        table.addColumn(genderColumn,"Gender");
        table.addColumn(ageColumn,"Age");

        ListDataProvider<ClientDto> dataProvider = new ListDataProvider<>();
        dataProvider.addDataDisplay(table);

        this.greetingService.list(new AsyncCallback<List<ClientDto>>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("error while writing table",throwable);
            }

            @Override
            public void onSuccess(List<ClientDto> clients) {
                logger.info("clients: " + clients);

                dataProvider.getList().addAll(clients);
            }
        });
        return dataProvider;
    }


    public void onModuleLoad() {

        ListDataProvider<ClientDto> dataProvider = createTable(table);
        DialogBox dialog = editDialog(dataProvider);

        Button add = new Button("Add", new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                name.setValue("");
                sureName.setValue("");
                gender.setValue("");
                age.setValue("");

                id = -1;
                dialog.center();
                dialog.show();
            }
        });

        Button edit = new Button("Edit", (ClickHandler) clickEvent -> {

            int rowIndex = table.getKeyboardSelectedRow();
            logger.info("rowIndex: " + rowIndex);
            ClientDto clientDto = dataProvider.getList().get(rowIndex);
            name.setValue(clientDto.getName());
            sureName.setValue(clientDto.getSureName());
            gender.setValue(clientDto.getGender());
            age.setValue(String.valueOf(clientDto.getAge()));

            logger.info("id: " + id);

            dialog.show();
            dialog.center();

        });

        Button delete = new Button("Delete", new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                final int index = table.getKeyboardSelectedRow();
                ClientDto client = dataProvider.getList().get(index);
                greetingService.delete(client, new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        GWT.log("Delete error",throwable);
                    }

                    @Override
                    public void onSuccess(Boolean aBoolean) {
                        dataProvider.getList().remove(index);
                    }
                });
            }
        });

        HorizontalPanel control = new HorizontalPanel();
        control.add(add);
        control.add(edit);
        control.add(delete);
        VerticalPanel panel = new VerticalPanel();
        panel.add(control);
        panel.add(table);
        RootPanel.get().add(panel);
    }

    private DialogBox editDialog(ListDataProvider<ClientDto> dataProvider) {
        final DialogBox dialogBox = new DialogBox();
        dialogBox.setText("Add note");
        dialogBox.setAnimationEnabled(true);
        VerticalPanel dPanel = new VerticalPanel();
        HorizontalPanel namePanel = new HorizontalPanel();
        Label label = new Label("Name");
        label.setWidth("100px");
        namePanel.add(label);
        namePanel.add(name);
        dPanel.add(namePanel);



        HorizontalPanel sureNamePanel = new HorizontalPanel();
        label = new Label("SureName");
        label.setWidth("100px");
        sureNamePanel.add(label);
        sureNamePanel.add(sureName);
        dPanel.add(sureNamePanel);

        HorizontalPanel genderPanel = new HorizontalPanel();
        label = new Label("Gender");
        label.setWidth("100px");
        genderPanel.add(label);
        genderPanel.add(gender);
        dPanel.add(genderPanel);

        HorizontalPanel agePanel = new HorizontalPanel();
        label = new Label("Age");
        label.setWidth("100px");
        agePanel.add(label);
        agePanel.add(age);
        dPanel.add(agePanel);

        HorizontalPanel dControl = new HorizontalPanel();

        dControl.add(new Button("Save", (ClickHandler) clickEvent -> {
            int rowIndex = table.getKeyboardSelectedRow();
            logger.info("rowIndex in save button: " + rowIndex);
            logger.info("Save button Id: " + id);
            greetingService.save(new ClientDto(),
                    new AsyncCallback<ClientDto>() {
                        @Override
                        public void onFailure(Throwable throwable) {
                            GWT.log("save error" + throwable,throwable);
                        }
                        @Override
                        public void onSuccess(ClientDto client) {

                            logger.info("field id: " + id);
                            if (id == -1 ) {
                                //add element
                                dataProvider.getList().add(client);
                                logger.info("client.id before" + client.toString());
                                logger.info("DATAPROVIDER LIST: ");
                                dataProvider.getList().forEach(i -> logger.info(i.toString()));
                            }else {
                                //edit element
                                logger.info("DATAPROVIDER LIST: ");
                                dataProvider.getList().forEach(i -> logger.info(i.toString()));

                                dataProvider.getList()
                                        .add(rowIndex,client);
                                dataProvider.getList().remove(rowIndex+1);
                            }

                            dialogBox.hide();
                        }
                    });

        }
        ));

        dControl.add(new Button("Cancel", (ClickHandler) clickEvent -> dialogBox.hide()));
        dPanel.add(dControl);
        dialogBox.setWidget(dPanel);
        return dialogBox;
    }
}
