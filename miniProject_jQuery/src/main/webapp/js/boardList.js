//$(document).ready(function(){});
$(function() {
   $.ajax({
      type: 'post',
      url: '/miniProject_jQuery/board/getBoardList.do',
      data: 'pg=' + $('#pg').val(), //JSON - {'pg': $('#pg').val()}
      dataType: 'json', //객체 못 받음 → 객체를 JSON으로 변환 후 가져온다
      success: function(data) {
         $.each(data.list, function(index, items){
            $('<tr/>').append($('<td/>', {
               align: 'center',
               text: items.seq
            })).append($('<td/>', {
           		 }).append($('<a/>',{
						href:'#',
						class:'subjectA',
						text: items.subject
           		 }))
           	 ).append($('<td/>', {
			   align: 'center',
               text: items.id
            })).append($('<td/>', {
			   align: 'center',
               text: items.hit
            })).append($('<td/>', {
			   align: 'center',
               text: items.logtime
            })).appendTo($('#boardListTable'));
         });
      //페이징 처리
      $('#boardpagingDiv').html(data.pagingHTML);
      
      //로그인 여부
      $('.subjectA').click(function(){
		  if($('#memId').val() =='')
		  	alert("먼저 로그인하세")
		  else{
			  var seq = $(this).parent().prev().text(); //글번호가져옴
			  console.log(seq);
			  
			  var pg = $('#pg').val();
			  location.href = '/miniProject_jQuery/board/boardView.do?seq='+seq+'&pg='+pg;
		  }
		  	
	  });
     
      },
      error: function(err) {
         console.log(err);
      }
   });
});