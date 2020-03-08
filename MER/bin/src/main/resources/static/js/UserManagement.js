/*Submit button Event*/
function submitButton() {
	var id = document.getElementById("student_id").value;
	if(id==0 || id==null){
		document.getElementById("studentForm").submit();
	}
	else {
		bootbox.confirm({
		    message: "Are You Sure You Want To Update"+id+"?",
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
	var elements = document.getElementById("student_id");
	console.log(elements.value);
	if(elements.value!=0) {
		window.location.href="/LGN002/MGT001";
	}
	else {
		document.getElementById("studentForm").reset();
	}
	}
	function deletefunction(id) {
		var message;
		var urlink="/LGN002/MGT001/student_delete/"+id;
		console.log("clicked button event for"+id);
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
	/*get townships by dvision selected*/
	document.getElementById("division").onfocusout=function() { 
		$("#township_select").empty();
		var div=document.getElementById("division").value;
		var urlink='/getTownship/'+div;
		
		 $.ajax({
		        type : 'GET',
		        url : urlink,
		        dataType : 'json',
		        contentType : 'application/json',
		        success : function(data) {
		            changeDatalist(data);
		         },
		 		fail : function(){console.log("ErroR")}
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
	  
	
	<!-- This is datatable function -->
	
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