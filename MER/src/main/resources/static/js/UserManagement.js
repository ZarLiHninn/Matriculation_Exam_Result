
/*Submit button Event*/
function submitButton() {
	var id = document.getElementById("student_id").value;
	if(id==0 || id==null){
		document.getElementById("studentForm").submit();
	}
	else {
		bootbox.confirm({
		    message: "Are You Sure You Want To Update ?",
		    buttons: {
		        confirm: {
		            label: 'Yes',
		            className: 'btn-danger'
		        },
		        cancel: {
		            label: 'No',
		        }
		    },
		    callback: function (result) {
		    	if(result){
		    		
		    		document.getElementById("studentForm").submit();
		    	}
		    }
		});
	}
		
}
/*Reset Button Event*/

function resetbutton() {	
		$("form#studentForm input[class=inputs]").each(function(){
			 var input = $(this);
			 input.val("");
			});
		$("form#studentForm input[class=roll]").each(function(){
			var input=$(this);
			input.val("");
		});
		$('#dob').val('').datepicker('update');
		$("form#studentForm input#nrc").val("-");
	}
/*Delete Button Event*/
function deletefunction(id) {
		var message;
		var host=window.location.host;
		var path=location.pathname.split('/')[1];
		//var urlink="http://"+host+'/'+path+"/LGN002/MGT001/student_delete/"+id;
		var urlink="http://"+host+"/LGN002/MGT001/student_delete/"+id;
		console.log(urlink);
		bootbox.confirm({
		    message: "Are You Sure You Want To Delete?",
		    buttons: {
		        confirm: {
		            label: 'Yes',
		            className: 'btn-danger'
		        },
		        cancel: {
		            label: 'No',
		        }
		    },
		    callback: function (result) {
		    	if(result){
		    		window.location.href=urlink;
		    		 console.log(message);
		    	}
		    }
		});
	}
	/*get townships by division selected*/
	document.getElementById("division").onfocusout=function() { 
		$("#township_select").empty();
		var div=document.getElementById("division").value;
		var host=window.location.host;
		var path=location.pathname.split('/')[1];
		//var urlink="http://"+host+'/'+path+'/getTownship/'+div;
		var urlink="http://"+host+'/getTownship/'+div;
		
		 $.ajax({
		        type : 'GET',
		        url : urlink,
		        dataType : 'json',
		        contentType : 'application/json',
		        success : function(data) {
		            changeDatalist(data);
		         },
		 		fail : function(){console.log("this is error phase")}
		 });
		
	}
	function changeDatalist(data) {
		document.getElementById("township").disabled=false;
	        for ( var i = 0, len = data.length; i < len; ++i) {
	            var township = data[i];
	            $('#township_select').append("<option th:value=\"" + township+ "\">"+township+"</option>");
	    }
	        console.log(data);
	}
	//this is date
	  
	
// This is datatable function
	
$(document).ready(function() {
	//set Bio checked
	document.getElementById("Bio").checked = true;
	//Notification Message
    var message = document.getElementById("message").value;
    if(message){
    	$.notify(message,"success");
    }
    // DataTable
    var table = $('#userList').DataTable( {
    	'autoWidth': true,
    	"responsive":true,
    	"pageLength":20,
    	 "dom": 'Bfrtip',
    	 "language": {
   	      "emptyTable": "There is no data to display",
   	      "zeroRecords": "There is no data to display"   	    	  
   	    },
         "buttons":[
        	 {
        		 extend:'pdfHtml5',
        		 text:'Export',
        		 title: 'Users',
        		 className: "float-right exportbtn btn btn-success ",
        		 exportOptions: { columns: "thead th:not(.noExport)" },
        		 customize: function(doc){
        			 doc.defaultStyle.alignment = 'center';
        			 doc.styles.tableHeader.fillColor='white';
        			 doc.styles.tableHeader.color='black';
        		 }
        	 }
         ]
    } );
 
    // Apply the search
    table.columns([1,2,3,4,5]).every( function () {
        var that = this;
 
        $( 'input', this.header() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );
    } );
    //DatePicker
    $( function() {
        $( "#dob" ).datepicker({
        	dateFormat: 'yy-mm-dd',
        	maxDate: "-16y",
        	uiLibrary: "bootstrap",
        	changeYear: true
        });
      } );
});
