$(document).ready(function() {
	
    // DataTable
    // Filter event handler
    // DataTable
    var table = $('#resultList').DataTable( {
    	"pageLength":20,
    	/*"language": {
            paginate: {
                previous: "<",
                next: ">"
            }
        },*/
    	'autoWidth': true,
    	 "dom": 'Bfrtip', 
         "buttons":[
        	 {
        		 extend:'pdfHtml5',
        		 text:'Export',
        		 title: 'Result Table',
        		 attr: {tabindex:11},
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
    table.columns([1,2,3,4,5,6,7,8,9,10]).every( function () {
        var that = this;
 
        $( 'input', this.header() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );
    } );
    var messagereceived=document.getElementById("message").value;
    if(message!=""){$.notify(messagereceived, "info");}
    
});
var getUpdateDatavalue=document.getElementById("getUpdateData").value;
if(getUpdateDatavalue!="")
	{
	var stuArray=getUpdateDatavalue.split(",");
    document.getElementById("stdName").value=stuArray[2];
    document.getElementById("year").value=stuArray[0];
    document.getElementById("year").disabled=true;
    document.getElementById("rollno").value=stuArray[1];
	}
document.getElementById("year").onfocusout=function() {
	$('#selectrollno').empty();
	var yeardiv=document.getElementById("year").value;
	if(yeardiv==""){document.getElementById("errorForYearList").innerText="Must Fill Year";}
	else{document.getElementById("errorForYearList").innerText="";}
	var urlink='/LGN002/selectedyear/'+yeardiv;
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
	document.getElementById("rollno").disabled=false;
        for ( var i = 0, len = data.length; i < len; ++i) {
            var user = data[i];
            $('#selectrollno').append("<option value=\"" + user+ "\">" + user+ "</option>");
    }    
}
document.getElementById("rollno").onfocusout=function() {
	var yeardiv=document.getElementById("year").value;
	var rollnodiv=document.getElementById("rollno").value;
	if(rollnodiv==""){document.getElementById("errorForRollNoList").innerText="Must Fill Roll Number.";}
	else{document.getElementById("errorForRollNoList").innerText="";}
	if(rollnodiv==""){
		 document.getElementById("stdName").value="";
         document.getElementById("stdId").value="";
	}
	else{var urlink1='/LGN002/selectedyear/'+yeardiv+'/'+rollnodiv;
	 $.ajax({
	        type : 'GET',
	        url : urlink1,
	        dataType : 'json',
	        contentType : 'application/json',
	        success : function(data) {
	            changeDatalist2(data);
	         },
	 		fail : function(){console.log("ErroR")}
	 });
	}
}
function changeDatalist2(data){
	var datastring=data[0];
	if(datastring==undefined){
		document.getElementById("errorForStudentName").innerText="There is no Student Name.";
		document.getElementById("stdName").value="";
		document.getElementById("stdId").value="";
	}
	else{
		document.getElementById("errorForStudentName").innerText="";
		var stuArray=datastring.split(",");
		document.getElementById("stdName").value=stuArray[1];
		document.getElementById("stdId").value=stuArray[0];
    }
          
}
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
			location.replace("http://localhost:8080/LGN002/deleteResult/"+id)
		}
	}
	});
}

function resetfunction()
{
	var length=document.getElementById("updatePopUp").innerText.length;
	if(length>4){
		var markAllId=document.querySelectorAll("[id='Mark']");
		for(var i=0;i<markAllId.length;i++){
		markAllId[i].value="";
		
		}
	}
	else{
		document.getElementById("reset").type="reset";
		document.getElementById("stdResultId").value="";
		document.getElementById("stdId").value="";
	}
}

$('#updatePopUp').click(function(e){
	var length=document.getElementById("updatePopUp").innerText.length;
	if(length>4){
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
		document.getElementById("stdId").value="";
	}
});
if(document.getElementById("Mark").value!=null && document.getElementById("updatePopUp").innerText.length<5){
	var markAllId=document.querySelectorAll("[id='Mark']");
	for(var i=0;i<markAllId.length;i++){
	markAllId[i].value="";
	
	}}