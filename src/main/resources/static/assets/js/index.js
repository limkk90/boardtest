$(document).ready(function() {
    // 대상.click도 가능하나 on을 쓰는 이유는 ul태그처럼 여러 메뉴가 있을때 동적으로 가져오기 위함

    // 회원가입
    $('#join').on('click', function () {
        let data = {
            id: $('#joinId').val(),
            password: $('#joinPW').val(),
            name : $('#name').val(),
        }

        $.ajax({
           data: data, // 전송할 데이터(JSON)
           type: 'post', // 전송할 방식
           url: '/rest/join', // 요청할 url
            success: function () { // 성공적으로 요청시 실행
               alert('회원가입 완료');
               window.location.href = '/'; // 해당 url로 이동
            }
        });
    });

    // 로그인
    $('#login').on('click', function () {
        let data = {
            id: $('#loginId').val(),
            password: $('#loginPW').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/login',
            success: function() {
                window.location.href = '/';
            }
        });

    });

    // 뒤로가기
    $('#back').on('click', function() {
        window.location.href = "/";
    });

    $('#write').on('click', function() {

        let data = {
            title: $('#title').val(),
            content: $('#content').val(),
            writer: $('#writer').val(),
            mno: $('#mno').val()
        }

        $.ajax({
            data : data,
            type: 'post',
            url: '/rest/write',
            success: function() {
                window.location.href = '/';
            }
        });
    });

    // 추천
    $('#reco').on('click', function() {
        let data = {
            bno: $('#bno').val()
        }

        $.ajax({
            data: data,
            type: 'put',
            url: '/rest/reco',
            success: function() {
                alert("추천!");
                location.reload();
            }
        });

    });

    // 글삭제
    $('#delete').on('click', function() {
        let data = {
            bno: $('#bno').val()
        }

        $.ajax({
            data: data,
            type: 'delete',
            url: '/rest/delete',
            success: function() {
                alert("삭제 완료");
                window.location.href = '/';
            }
        });
    });

    // 글 수정 버튼
    $('#updateBtn').on('click', function() {
        let bno = $('#bno').val();
        window.location.href = '/update/' + bno;
    });

    // 글 수정
    $('#update').on('click', function() {
        let data = {
            title: $('#title').val(),
            content: $('#content').val(),
            writer: $('#writer').val(),
            bno: $('#bno').val()
        }

        $.ajax({
            data: data,
            type: 'put',
            url: '/rest/update',
            success: function () {
                alert('수정 완료!');
                window.location.href = '/select/' + data.bno;
            }
        });
    });

    $('#reply').on('click', function () {
        let data = {
            rcontent: $('#rcontent').val(),
            rwriter: $('#rwriter').val(),
            mno: $('#mno').val(),
            bno: $('#bno').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/reply',
            success: function() {
                alert('댓글 작성');
                window.location.href = "/select/"+data.bno;
            }
        });
    });

    // 이메일 전송
    $('#sendEmail').on('click', function() {
        let data = {
            userEmail: $('#email').val()
        }

        $.ajax({
           data: data,
            type: 'post',
            url: '/rest/email',
            success: function() {
                alert('인증번호를 전송했습니다.');
            }
        });
    });

    // 인증
    $('#confirm').on('click', function() {

        let data = {
            confirm: $('#confirmCode').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/confirm',
            success: function(i) {
                if(i == 1) {
                    alert('인증되었습니다.');
                    $('#join').attr('disabled',false);
                } else alert('인증 실패');
            }
        });
    });
})

function up (no) {
    let rno = no;
    let data = {
        bno: $('#bno').val(),
        rno: rno
    }

    $.ajax({
        data: data,
        type: 'put',
        url: '/rest/up',
        success: function() {
            location.reload();
        }
    });
}

function down (no) {
    let rno = no;
    let data = {
        bno: $('#bno').val(),
        rno: rno
    }

    $.ajax({
        data: data,
        type: 'put',
        url: '/rest/down',
        success: function() {
            location.reload();
        }
    });
}