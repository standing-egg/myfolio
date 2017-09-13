/*
 * - 테트리스의 실제 동작에 대한 스크립트
 * 웹브라우저는 외부 자바스크립트를 불러오는 <script> 태그를 만나면,
 * 먼저 해당 스크립트를 해석하고 실행한 뒤에 HTML 코드를 파싱한다
 * 따라서 HTML의 DOM 트리가 생성되기 전에, 스크립트를 실행하기 때문에
 * 아래의 #stage 요소가 만들어지지 않은 상태에서 .addClass()가 실행된다
 * -> 해결법은 <script> 태그에 defer 속성을 추가하여 HTML 해석이 끝나고 스크립트를 실행하게 한다
 * -> $(document).ready() : HTML의 모든 DOM 요소가 해석되면 자동으로 실행된다
 */

$(document).ready(function(){
	/*$(".test").text('testing');*/
    for(var i=0; i < 20; i++){
        for(var j=0; j < 10; j++){
        	// A.addClass(className) : A에 className이라는 이름의 클래스 추가 (띄어쓰기로 여러개 추가)
			// A.appendTo(target) : target에 해당하는 요소 마지막에 A를 추가
			// .block과 .none 이라는 클래스를 추가하여 격자 무늬를 만듦 (tetris.css의 요소)
            $("<div>").addClass("block none").appendTo("#stage");
        }
    }
    //setType("type2"); //테스트용
    handle.init();
    
	// setInterval(function, T) : 일정 간격(T)으로 function을 수행
	// clearIntervla()을 사용해서 setinterval()을 종료하기 위해 iterval 변수에 저장해서 사용
    interval = setInterval(function(){
        handle.setDown();
    }, handle.speed);
});

//.keydown() 메서드로 키보드 입력을 처리하는 함수
$(document).keydown(function(e){
    switch(e.which){
        case 39 : //right key
            handle.setRight();
            break;
        case 37 : //left key
            handle.setLeft();
            break;
        case 40 : //down key
            handle.setDown();
            break;
        case 38 : //up key
            handle.rotate();
            break;
        case 32 : //space key
            handle.drop();
            break;
    }
});

//테트리스 블럭을 생성하는 함수 (테스트용) -> 수정해서 핸들링 객체에 넣어서 사용
//types.js에서 정의한 블럭의 타입이 필요
//tetris.css에서 #stage와 #handle에 position을 설정해야 레이어가 겹치거나 벗어나지 않음
/*function setType(typeName) {
	
	var type = types[typeName];
	var width = type.width;
	var height = type.height;
	
	// A.empty() : A의 하위 요소와 text들을 삭제 (A요소만 남음, A의 text는 삭제)
	// A.width(value) : A의 css 너비를 변경 (value가 없으면 해당 요소의 너비값 반환)
	// A.height(value) : A의 css 높이를 변경(value가 없으면 해당 요소의 높이값 반환)
	// 테트리스 블록이 생성될 영역(#handle) 초기화, 너비(타입의 칸 수*한 칸의 너비)와 높이(타입의 칸 수*한 칸의 높이) 설정
	$("#handle").empty().width(width*25).height(height*25);
	
	for (var i = 0; i < height; i++) {
		for (var j = 0; j < width; j++) {
			// 블럭의 1과 0으로 이루어진 shape 배열에서 1에 해당할 때 색상을 지정
			if (type.shape[i][j]) {
				// #handle에 <div class="typeName block">를 추가
				$("<div>").addClass(typeName).addClass("block").appendTo("#handle");
			} 			
			// 0인 경우 빈칸으로 처리
			else {
				$("<div>").addClass("whiteLine").addClass("block").appendTo("#handle");
			}
		}
	}
}*/

//블럭의 움직임을 컨트롤하기 위한 핸들링 객체
var handle = {
    "type" : "none",					// 블록의 type
    "top" : 0,							// 블록의 top 좌표
    "left" : 0,							// 블록의 left 좌표
    "width" : 0,						// 블록의 너비
    "height" : 0,						// 블록의 높이
    "rotation" : 0,						// 회전 방향
    "speed" : 1000,						// 블록이 내려온느 속도 간격(ms)
    
    "init" : function(){				// 블록 초기화와 랜덤으로 생성하여 상단에 배치
        this.top = 0;
        this.left = 0;
        this.width = 0;
        this.height = 0;
        this.rotation = 0;
        // Math.floor() : 소수점 이하를 버림
		// 1~7 사이의 랜덤값을 얻어서 setType()으로 블록을 생성
        this.setType("type"+(Math.floor(Math.random()*10)%7 + 1));
        this.setTop();
        this.rotate(0);
        
        this.move();
    },
    "setType" : function(typeName){		// 블록 타입 설정
    	
    	// 아래의 type, width, height 는 handle 객체에서 이용하기 위해 각각의 속성을 저장하도록 수정됨 
        this.type = types[typeName];
        var width = this.width = this.type.width;
        var height = this.height = this.type.height;
        
        // A.empty() : A의 하위 요소와 text들을 삭제 (A요소만 남음, A의 text는 삭제)
		// A.width(value) : A의 css 너비를 변경 (value가 없으면 해당 요소의 너비값 반환)
		// A.height(value) : A의 css 높이를 변경(value가 없으면 해당 요소의 높이값 반환)
		// 테트리스 블록이 생성될 영역(#handle) 초기화, 너비(타입의 칸 수*한 칸의 너비)와 높이(타입의 칸 수*한 칸의 높이) 설정
        $("#handle").empty().width(width * 25).height(height * 25);

        for(var i=0; i < height; i++){
            for(var j=0; j < width; j++){
            	// 블럭의 1과 0으로 이루어진 shape 배열에서 1에 해당할 때 색상을 지정
                if(this.type.shape[i][j]){
                	// #handle에 <div class="typeName block">를 추가
                    $("<div>").addClass("block").addClass(typeName).appendTo("#handle");
                }
                // 0인 경우 빈칸으로 처리
                else {
                    $("<div>").addClass("block").addClass("whiteLine").appendTo("#handle");
                }
            }
        }
    },
    "move" : function(){				// 블록 이동
    	// .animate(properties, options) : css속성과 옵션(지속시간, 시작 끝 효과 등)으로 움직이는 효과를 만듦
		// 25는 한 칸의 가로와 세로 길이를 의미
        $("#handle").animate({"top":this.top*25, "left":this.left*25}, 50);
        // 블록 이동 후 라인 검사와 삭제
        this.clearLine();
    },
    "setTop" : function(){				// 블록을 맨 위로 이동
    	// 블록을 상단 가운데 배치, 회전방향 리셋, top과 left값 수정 
        this.left = 4;
        this.top = 0;
        this.rotation = 0;
        $("#handle").css({"top":this.top*25, "left":this.left*25});
        
        // 블록이 충돌하면 게임 오버처리 하기 위해서 interval을 제거
        if(this.checkCollision()){
            clearInterval(interval);
            alert("Game Over");
        }
    },
    "setRight" : function(){			// 블록을 오른쪽으로 한 칸 이동
        this.left+=1;
        
        // 좌표 이동 시 충돌 여부 확인
        if(this.checkCollision()){
            this.left-=1;
        };
        this.move();
    },
    "setLeft" : function(){				// 블록을 왼쪽으로  한 칸 이동
        this.left-=1;
        
        // 좌표 이동 시 충돌 여부 확인
        if(this.checkCollision()){
            this.left+=1;
        };
        this.move();
    },
    "setDown" : function(){				// 블록을 밑으로 한 칸 이동
        this.top+=1;
        
        // 좌표 이동 시 충돌 여부 확인
        if(this.checkCollision()){
            this.top-=1;
            
            // setDown()에서의 충돌은 블록이 더 이상 내려갈 수 없는
			// 상황이기 때문에 블록을 쌓고 새로운 블록을 생성한다 
            this.fillBlock();
            this.init();
        };
    
        this.move();
    },
    "rotate" : function(rotation){		// 블록 회전
        if(rotation != 0){
            this.rotation++;
            // rotation = this.rotation을 this.type.maxRotation으로 나눈 나머지
			// A %= B는 계산값을 A에 복사하기 때문에 rotation이 0이 될 때 this.rotation도 0이 됨
            rotation = this.rotation %= this.type.maxRotation;
        }
		// 좌표 이동 시 충돌 여부 확인
        if(this.checkCollision()){
            this.rotation--;
            this.rotation %= this.type.maxRotation;
        }
        else {
			// handle 레이어를 90도 단위로 회전시키는 함수
			// transform : 요소의 위치나 모양을 변형하거나 회전시키는 css 속성
			// rotate(deg) : transform의 옵션으로 회전 효과 
            $("#handle").css("transform", "rotate("+ rotation*90 +"deg)");
        }
        this.move();
    },
    
	// 아래는 예외사항 처리
	/* 레이업 밖으로 블록이 나가지 않음
	 * 하단 벽에 닿으면 블록이 쌓임
	 * 블록이 한 라인을 채우면 라인이 지워짐
	 * 블록이 자동으로 떨어지
	 * 블록이 상단 끝에 닿으면 게임오버
	 * 블록 회전 시 기존의 블록이나 벽과 겹치지 않음 
	 */
    
    "clearLine" : function(){			// 블록이 가득찬 라인을 검사해서 해당 라인을 지움
        var blocks = $("#stage > .block");
        var count = 0; // 라인에 쌓여있는 블럭 개수 (10개가 되면 삭제)
        for(var i=0; i < 20; i++){
            for(var j=0; j < 10; j++){
				// 빈 블록이 있는 경우 다음 라인으로 넘어감
				// .eq(index) : index에 해당하는 요소를 찾음
				// .hasClass(className) : 해당 클래스가 있는지 확인하고 boolean값 반환
            	if(blocks.eq(i*10 + j).hasClass("none")){
                    break;
                }
                count++;
            }
			// 10개 블록이 모두 차있는 경우
            if(count == 10){
                for(var k=0; k < 10; k++){
					// 한 줄이 다 찬 블록을 지우고 그 위에 있던 블록을 지워진 라인으로 내림
                    blocks.eq(i*10 + k).remove();
					// A.prependTo("target") : target 요소 시작 부분에 A 요소를 삽입
                    $("<div>").addClass("block none").prependTo("#stage");
                }
            }
            count = 0;
        }
    },
    "rotateCoord" : function(i, j){			// 회전 시 블록 모양의 좌표계 계산
		// 벽이나 다른 블록에 충돌하는지 검사하기 위해 좌표를 계산
		
		// x는  this.type.shape[i][j]의 i
		// y는  this.type.shape[i][j]의 j
        var x,y;
        
        switch(this.rotation%4) {
            case 0:		// 원래 좌표
                x=i;
                y=j;
                break;
            case 1:		// 90도 회전 좌표
                x=j;
                y=this.width-i-1;
                break;
            case 2:		// 180도 회전 좌표
                x=this.height-i-1;
                y=this.width-j-1;
                break;
            case 3:		// 270도 회전 좌표
                x=this.width-j-1;
                y=i;
                break;
            default:	// 360도 회전 좌표
                x=i;
                y=j;
        }
        return {"x":x, "y":y};
    },
    "checkCollision" : function(){		// 벽이나 다른 블록과 겹치는지 검사
        var left = this.left;
        var top = this.top;
        
        var width = this.width;
        var height = this.height;
        
        for(var i=0; i < height; i++){
            for(var j=0; j < width; j++){
				// x는  this.type.shape[i][j]의 i
				// y는  this.type.shape[i][j]의 j
            	var x,y;
                var coord = this.rotateCoord(i,j);
                x = coord.x;
                y = coord.y;
                
                if(this.type.shape[i][j] == 1){
					// 벽에 닿을 경우
                    if(top + x > 19) {			// 바닥에 닿은 경우 
                        return true;
                    }
                    else if(left + y < 0) {	// 왼쪽 벽에 닿은 경우
                        return true;
                    }
                    else if(left + y > 9) {	// 오른쪽 벽에 닿은 경우
                        return true;
                    }
                    
					// 다른 블록에 닿을 경우
					// this 블록의 좌표에 다른 블록이 있는 경우
                    if(!$("#stage > .block").eq((this.top+x)*10 + this.left+y).hasClass("none")){
                        return true;
                    }
                }
            }
        }
        return false;
    },
    "fillBlock" : function(){			// 지금의 위치에 블록을 쌓음
        var width = this.width;
        var height = this.height;
        
        for(var i=0; i < height; i++){
            for(var j=0; j < width; j++){
                var x,y;
                var coord = this.rotateCoord(i,j);
                x = coord.x;
                y = coord.y;
                
                if(this.type.shape[i][j] == 1){
					// 현재 블록의 위치에 none 클래스 블록을 지우고 현재 블록을 쌓음
                    $("#stage > .block")
                    	.eq((this.top+x)*10 + this.left+y)
                    	.removeClass("none")
                    	.addClass(this.type.name);
                }
            }
        }
    },
    "drop" : function(){				// 블록을 떨어뜨림(space key)
        while(!this.checkCollision()){
            this.top++;
        }
        this.top--;			// 블록이 충돌하면 top-- 처리
        this.fillBlock();
        this.init();
        this.move();
    },
};
