package com.demo.adapter.in.web.ui;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Builder
@ToString
public class ModelViewForm {
    private final String wtid;
    private final String mid;

    @Setter
    @Builder.Default
    private String useKeyPadYn = "Y";

    /** 화면으로 내려가기 전 프로세스 처리에 필요한 데이터들을 암호화한 값 */
    @Setter
    private String acctkn;

    /** 가맹점 기준정보 */
    @Setter
    private Map<String, Object> basicInfo;

    /** form data */
    @Setter
    private Object data;
}
