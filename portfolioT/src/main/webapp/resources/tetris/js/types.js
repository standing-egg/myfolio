/* 
 * 7가지 테트리스 블록에 대한 정보 (너비(칸), 높이(칸), 최대 회전수, 모양)
 */

var types = {};

types.type1 = {
		"name" : "type1",
		"width" : 2,
		"height" : 2,
		"maxRotation" : 1,
		"shape" : 	[[1,1],
		          	 [1,1]]
	};
	types.type2 = {
		"name" : "type2",
		"width" : 3,
		"height" : 3,
		"maxRotation" : 4,
		"shape" : 	[[0,1,0],
	        		 [1,1,1],
	        		 [0,0,0]]
	};
	types.type3 = {
		"name" : "type3",
		"width" : 4,
		"height" : 4,
		"maxRotation" : 2,
		"shape" : 	[[0,1,0,0],
	        		 [0,1,0,0],
	        		 [0,1,0,0],
	        		 [0,1,0,0]]
	};
	types.type4 = {
		"name" : "type4",
		"width" : 3,
		"height" : 3,
		"maxRotation" : 4,
		"shape" : 	[[0,1,0],
	        		 [0,1,0],
	        		 [0,1,1]]
	};
	types.type5 = {
		"name" : "type5",
		"width" : 3,
		"height" : 3,
		"maxRotation" : 4,
		"shape" : 	[[0,1,0],
	        		 [0,1,0],
	        		 [1,1,0]]
	};
	types.type6 = {
		"name" : "type6",
		"width" : 3,
		"height" : 3,
		"maxRotation" : 2,
		"shape" : 	[[1,0,0],
	        		 [1,1,0],
	        		 [0,1,0]]
	};
	types.type7 = {
		"name" : "type7",
		"width" : 3,
		"height" : 3,
		"maxRotation" : 2,
		"shape" : 	[[0,1,0],
	        		 [1,1,0],
	        		 [1,0,0]]
	};