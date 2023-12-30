/**
 * 결제 비밀번호 인증
 * @type {InputKeypad}
 */
const InputKeypad = class {

    constructor() {
        this.wtid = "";
        console.log('Call InputKeypad.constructor');
    }

    /** 입력 핀번호 확인 */
    confirmPinNumb($form) {
        console.log('Call InputKeypad.confirmPinNumb');
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/proceed/v1/confirm-pin-numb',
            data: $form,
            success: (data) => {
                console.log(data);
                return true;
            },
            error: (xhr) => {
                console.log(xhr);
                return true;
            }
        });
    }
}