    var message=document.getElementById("message").value;
    if(message!=""){$.notify(message, "info");}

    function deletefunction(id){
    	bootbox.confirm({
    		message:"Are you sure to delete?",
    	buttons:{
    		confirm:{
    			label:'Yes',
    			className:'btn-danger',
    		},
    		cancel:{
    			label:'No',
    		}
    	},
    	callback:function(result){
    		if(result){
    			location.replace("/delete/"+id)
    		}
    	}
    	});
    }

    function resetfunction()
    {
    	var division=document.querySelectorAll("[id='division']");
    	if(document.getElementById("updatePopUp").innerText=="Update"){
    		division[0].value="17";
    		division[0].text="Division";
    		var township=document.querySelectorAll("[id='township']");
    		for(var i=0;i<township.length;i++){
    		township[i].value="";
    		}
    	}
    	else {
    		document.getElementById("reset").type="reset";
    	}
    }
    $('#updatePopUp').click(function(e){
    	if(document.getElementById("updatePopUp").innerText=="Update"){
    		e.preventDefault();
    		bootbox.confirm({
    			message:"Are you sure to Update?",
    		buttons:{
    			confirm:{
    				label:'Yes',		
    			},
    			cancel:{
    				label:'No',
    				className:'btn-danger',
    			}
    		},
    		callback:function(result){
    			if(result){
    				$('#formsubmit').submit();
    			}
    		}
    		});
    	}
    	else{
    		document.getElementById("updatePopUp").type="submit";
    	}
    })
    $(document).ready(function() {
    // DataTable
    // Filter event handler
    var table = $('#townshipList').DataTable( {
    	'pageLength':10,
    	'autoWidth': false,
    	 "dom": 'Bfrtip',        
         "buttons":[
        	 {
        		 extend:'pdfHtml5',
        		 text:'Export',
        		 title: 'Township Table',
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
    table.columns([1,2,3]).every( function () {
        var that = this;
 
        $( 'input', this.header() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );
    } );
});