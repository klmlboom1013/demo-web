package com.demo.ui.adapter.in.web.billings;

import com.demo.ui.domain.MapperMpiBasicInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@ToString
public class BillingSignupForm {
    private final String wtid;
    private final String mid;
    private final String pinFlagYn;
    /** 화면으로 내려가기전 프로세스 처리에 필요한 데이터들을 암호화한 값 */
    private String acctkn;

    /** 가맹점 기준정보 */
    private final Map<String, String[]> basicInfo = new HashMap<>();


    /** 프로세스 처리에 필요한 데이터들을 암호화 한다. */
    public void setAcctkn(Object... args) {
        
    }

    /** 필요한 기준정보만 추려서 맵에 저장 후 화면으로 보낸다.*/
    public void setBasicInfoData(MapperMpiBasicInfo  mpiBasicInfo) {

    }
}
