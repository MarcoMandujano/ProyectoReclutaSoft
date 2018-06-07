
	
$(document).ready(function() {

//   var tableLider = $('#tbLiderList').DataTable( {
//        select: true
//    });
//    
//    $('#tbLiderList tbody').on( 'click', 'tr', function () {
//	    console.log( tableLider.row( this ).data() );
//	} );
    
    var tableLider = $('#tbLiderList2').DataTable( {
        select: true
    });
    
    $('#tbLiderList2 tbody').on( 'click', 'tr', function () {
	    console.log( tableLider.row( this ).data() );
	} );
});
	


function choiceFromTable(table) {
	
	
}