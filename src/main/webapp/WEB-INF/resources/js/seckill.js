//javascript 模块化
var seckill = {
    //封装秒杀相关ajax的url
    URL : {

    },
    //验证手机号
    validatePhone:function(phone) {
        if(phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        } else {
            return false;
        }
    },
    //详情页秒杀逻辑
    detail: {
        //详情页初始化
       init:function(params) {
            //用户手机验证和登录，计时交互
           var killPhone = $.cookie('killPhone');
           var startTime = params['startTime'];
           var entTime = params['endTime'];

           //验证手机号
           if(!seckill.validatePhone(killPhone)) {
               //绑定phone
               var killPhoneModal = $('#killPhoneModal');
               //显示弹出层
               killPhoneModal.modal({
                   show:true,
                   backdrop:'static',//禁止位置关闭
                   keyboard:false//关闭键盘事件
               });
               $('#killPhoneBtn').click(function() {
                  var inputPhone = $('#killPhoneKey').val();
                   if(seckill.validatePhone(inputPhone)) {
                       //电话写入cookie
                       $.cookie('killPhone',inputPhone,{expires:7,path:'/seckill'});
                       //刷新页面
                       window.location.reload();
                   } else {
                       $.('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
                   }
               });
           }
       }
    }
}