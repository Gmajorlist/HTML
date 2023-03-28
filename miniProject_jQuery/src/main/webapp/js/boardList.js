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
               text: items.subject
            })).append($('<td/>', {
               text: items.id
            })).append($('<td/>', {
               text: items.hit
            })).append($('<td/>', {
               text: items.logtime
            })).appendTo($('#boardListTable'));
         });
      },
      error: function(err) {
         console.log(err);
      }
   });
});