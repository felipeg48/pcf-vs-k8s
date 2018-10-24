layout 'layout/main.tpl',
        pageTitle: 'Directory',
        mainBody: contents {
            div(class: 'col-xs-12 col-sm-9'){

                div(class: 'jumbotron') {
                    h1('Welcome')
                    p('A new way to manage your Personnel')
                }

                div(class: 'row') {
                    div(class: 'panel panel-primary') {
                        div(class: 'panel-body') {
                                div(class: 'form-group pull-left') {
                                    label(for: 'email', 'Email')
                                    input(class: 'form-control', type: 'email', placeholder: 'Email', id: 'email')
                                }
                                div(class: 'form-group pull-left', style: 'padding-left: 5px;') {
                                    label(for: 'name', 'Name')
                                    input(class: 'form-control', type: 'text', placeholder: 'Name', id: 'name')
                                }
                                div(class: 'form-group pull-left', style: 'padding-left: 5px;') {
                                    label(for: 'phone', 'Phone')
                                    input(class: 'form-control', type: 'text', placeholder: 'Phone', id: 'phone')
                                }
                        }
                        div(class: 'panel-footer') {
                            button(class: 'btn btn-primary', type: 'button', id: 'person', 'Submit')
                        }
                    }
                }


                div(class: 'row') {
                    table(class: 'table table-striped', id: 'people') {

                        th ("Email")
                        th ("Name")
                        th ("Phone")

                        tbody {
                            people.each { person ->
                                tr {
                                    td(person.email)
                                    td(person.name)
                                    td(person.phone)
                                }
                            }
                        }
                    }
                }


            }

            script {
                yieldUnescaped '''
                    $(function(){
                       var person = {};
                       $("#person").click(function(){
                            
                            person = { 
                                email : $("#email").val(),
                                name  : $("#name").val(),
                                phone : $("#phone").val()
                            };
                            
                            $.ajax({
                              type: "POST",
                              url: "/",
                              data: JSON.stringify(person),
                              contentType: "application/json",
                              success: function(data){
                                   var row = "<tr><td>" + data.email  + "</td><td>" + data.name + "</td><td>" + data.phone  +"</td></tr>";
                                   $("#people > tbody").append(row);
                              }
                            });
                        
                           
                       });
                        
                    });
                '''

            }
        }