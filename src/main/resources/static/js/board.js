console.log("board Module...");

let boardService = (function() {

	function add(board,callback){

		$.ajax({

			type : "POST",
			url : "/boards/",
			cache : false,
			contentType:'application/json; charset=utf-8',
			data: JSON.stringify(board),
			success: function (result) {
				if(result == "SUCCESS"){
					console.log(result);
					callback();
				}
			},
			error: function (e) {
			        console.log(e);
			    }
			}); //	   $.ajax({
	}

	function del(id, callback){

        $.ajax({
    	type : "DELETE",
        url : "/boards/" + id,
    	success: function (result) {
    	    console.log(result);
    	    if(callback){
    			callback();
    	    }
    	},
            error: function (e) {
    		 console.log(e);
          }
    	});
    }

	function update(board,callback){

		$.ajax({

			type : "PUT",
			url : "/boards/",
			cache : false,
			contentType:'application/json; charset=utf-8',
			data: JSON.stringify(board),
			success: function (result) {
				if(result == "SUCCESS"){
					console.log(result);
					callback();
				}
			},
			error: function (e) {
			        console.log(e);
			    }
			}); //	   $.ajax({
	}

    return {
        add : add,
        del : del,
        update : update

    }

})();