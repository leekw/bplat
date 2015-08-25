package com.pp.bplat.common.support.util;

public abstract class Constant {
	
	public void setPMD(String str) {
		str.toString();
	}
	
	public enum PartnerUser {
		PARTNER_USER("PARTNER_USER");
		private String value;
		private PartnerUser(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	public enum Data {
		JSON("json"), XML("dxml"), FILE("file"),SER("SER");
		private String value;
		private Data(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	public enum RunLevel {
		DEV("DEV"),
		TEST("TEST"),
		REAL("REAL");
		private String value;
		private RunLevel(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	public enum System {
		SYSTEM("SYSTEM"),
		EMPTY_STRING(""), 
		ENCODING_TYPE_OF_UTF8("UTF-8"),
		CONTENT_TYPE_TEXT_PLAIN("text/plain"), 
		DASH_STRING("/"),
		DELIMITER_SEMI_COLON(";"), 
		DELIMITER_COLON(":"),
		FILE_NOT_EXIST("ERROR.0007"),
		FORM("FORM"),
		PERCENT_STRING("%"),
		AT_SIGN_STRING("@"),
		COMMA_STRING(","),
		ELLIPSIS_STRING("..."),
		EXCEPTION_FLAG("####################: "),
		RETURN_KEY("\n"),
		NULL_STRING("NULL"),
		UNDER_BAR("_"),
		DOT(".");
		private String value;
		private System(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	/**
	 * 관리수수료 유형 구분.
	 * @author kyung
	 *
	 */
	public enum ManageMentAmtType {
		OLLEH_Y("Y"),
		VOC_CNT("VOC_CNT");
		private String value;
		private ManageMentAmtType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	/**
	 * lob유형 
	 * @author kyung
	 *
	 */
	
	public enum LobType {
		WIFI("WFLB07893"),
		WIBRO("WBLB07913"),
		PSTN("PSLB08123"),
		NON_TELCO("NONTELLOB"),
		MOBILE("KT_MOBILE"),
		IPTV("KT_IPTV"),
		INTERNET("KT_INTNET"),
		BUNDLE("BDLB07000"),
		BIZMEKA("BMLB0000001"),
		SOIP("KTSOIPLOB");
		private String value;
		private LobType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	
	public enum SystemFactor{
		DEDUCTION_AMOUNT(111),//차감금액 
		ADD_RATIO(112),//추가지급율 
		RATIO_ADD_GRAVITY(113),//지급율 증가비중 
		INCENTIVE_RATIO(114),//인센티브율 
		INCENTIVE_AMOUNT(115),//인센티브금액 
		AGENCY_CLASS(116),//대리점 등급 
		SCORE(117),//대리점점수 
		TRGT_AMT(118), //올레 대상금액(판돈) voc -20	00
		PAYMENT_RATIO(119), //수납요율 
		COMPETING_GROUPS(120),
		OLLEH_ORG_YN(110),//올레대상조직여부 FACTOR_ID
		MANAGE_PAYMENT_RATIO(700),//관리수수료요율 FACTOR_ID
		VOC_ORG_YN(319),//VOC 조직대상여부 
		VOC_COUNT(900),//VOC 건수 
		SR_SCORE(312),//SR점수 
		CSI_SCORE(305),//CSI점수 
		SPEED_SCORE(306),//전속도 
		EDUCATION_SCORE(307),//교육가점  
		PRIVATE_POLICY_SCORE(310),//단별정책 
		CALL_SCORE(313),//콜점수 
		REJECT_CANCEL(311),// 해지거부점수 
		VOC_RATION(314),//VOC 적용요율 olleh에서 대리점등급산정시 사용 factor
		NETINC_INCNT_C_RATIO(500), //순증인센티브해지율 
		CUMMULATED_TYPE(612),//실적유형,old는 VOC 적용대상여부 VOC_CNT 였음 
		REF_SALES_CNT(908),//참조실적건수 
		POLICY_FEE_DIVISION(998),//분배정책에 VOC 분배인지 OLLEH분배인지 결정짓는 FACTOR
		ENTR_TERM_MONTH(316),//관리수수료 지급 가입개월수 
		TRANSFER_FEE(999), //관리수수료 이관
		REF_PAYMENT_AMT(909),  //참조수납금액
		BUNDLE_CALLPLAN(3260),  //결합요금제
		BUNDLE_PRODUCT(3270),  //결함단말기
		
		MANAGE_PAY_TYPE(3500),//관리수수료 지급유형
		PAYMENT_ITEM(1710), // 피쳐코드
		SOURCE_AMT(121),//근거발생금액(3G음성관리수수료 인수점기준 총SUM)
		FIXED_RATIO(122),//고정지급율(1% - (100% ~ 65.2%)
		PURE_ENTRY_CNT(123),//순신규건수(12개월의 순신규 건수 7월월
		RANK(124),//경쟁구룹내 자기 위치점 
		MAIN_PRODUCT_ALL(2870),//MAIN 상품
		PRODUCT_ALL(1320), //상품 
		ACCUM_VALUE(1930),//집계값.
		
		SETL_HNDSET_NO(1470),// 단말기일련번호 번호
		BAN_NUM(1170),// BAN 번호
		ACCOUNT(1234),//계정 FACTOR 분반기별 수수료계산시 사용 
		TARGET_ORG(1010),//대상조직 (분반기별 정책시 집게데이터를 FACTOR로 만들기 위해 사용 )
		EVENT_DATE(1030), // 발생일시
		LOB(1360),		//lob
		COMBI_TYPE(3140), // 결합유형 - 결합집계 때문에 추가
		COMBI_LOB(3150), // 결합유형 - 결합집계 때문에 추가
		COMBI_INFO(3180), // LOB조합정보 - 결합집계 때문에 추가
		COMBI_ACCUM(3880), //결합 집계값.
		USED_DAY(1110), //사용일수
		BUNDLE_ACCEPT(3230), //BUNDLE 접수일자
		ACPT_OBDNG(3940), //수용국 
		SALE_OFC(3950) //판매국
		;		
		
		private int value;
		private SystemFactor(int value){
			this.value = value;
		}
		public int getValue(){
			return value;
		}
		public boolean isMatch(int compare) {
			return value == compare;
		}
	}
	
	public enum SystemFactorValue {
		POLICY_FEE_DIVISION_OLLEH("OLLEH"),//분배정책에 VOC 분배인지 OLLEH분배인지 결정짓는 factorValue
		POLICY_FEE_DIVISION_VOC("VOC"), //분배정책에 VOC 분배인지 OLLEH분배인지 결정짓는 factorValue
		ORD_PRC_WRK_VICEX_C("ORD_PRC_WRK_VICEX_C"), //업무대행취소
		ORD_PRC_MD("ORD_PRC_MD"), //기기변경오더
		ORD_PRC_MD_CA("ORD_PRC_MD_CA"), //기기변경취소오더
		ORD_PRC_OP("ORD_PRC_OP"), // 개통 오더
		ORD_PRC_NM("ORD_PRC_NM"), // 명의변경 오더
		ORD_PRC_ORG_RMNY("ORD_PRC_ORG_RMNY"), // 수납대행 오더
		ORD_PRC_ORG_RMNY_CNCL("ORD_PRC_ORG_RMNY_CNCL"), // 수납대행 오더
		ORD_PRC_CALL_HST_RD("ORD_PRC_CALL_HST_RD"), // 통화내역열람 오더
		ORD_PRC_PD_SM("ORD_PRC_PD_SM"), // 요금제변경 오더
		ORD_PRC_MB_CHG("ORD_PRC_MB_CHG"), // 번호변경 오더
		ORD_PRC_MB_RSP("ORD_PRC_MB_RSP"), // 정지해제 오더
		ORD_PRC_MB_SUS("ORD_PRC_MB_SUS"), // 이용정지 오더
		ORD_PRC_C_RC("ORD_PRC_C_RC"), // 해지복구 오더
		ORD_PRC_MB_NV_OP("ORD_PRC_MB_NV_OP"), // 해지복구 오더
		ORD_PRC_AS_VICEX("ORD_PRC_AS_VICEX"), // AS대행변경 오더
		ORD_PRC_BAN_CHG("ORD_PRC_BAN_CHG"), // 청구계약변경 오더
		ORD_PRC_PAY_METH_CHG("ORD_PRC_PAY_METH_CHG"), // 납부방법변경 오더
		ORD_PRC_PAY_METH_CHG_GIRO("ORD_PRC_PAY_METH_CHG_GIRO"), // 납부방법변경(지로) 오더
		ORD_PRC_C("ORD_PRC_C"), //해지
		VPWS("VPWS"), //수수료피쳐코드 음성
		BASE_PAID("BASE_PAID"),//기본관리점지급
		DIV_PAID("DIV_PAID"), //2%차감지급
		MOD_PAID("MOD_PAID"), //변경관리점지급
		PAY_DIRECT_DEBIT("PAY_DIRECT_DEBIT"), //납부방법변경(자동이체)
		PAY_GIRO("PAY_GIRO"), //납부방법변경(지로)
		ORD_PRC_W_EM("ORD_PRC_W_EM"), //약정기간변경
	    TOTAL("TOTAL"),//전체 
	    MAIN_PRODUCT_ALL("ALL"),//MAIN  상품전체 PolicyResourceKey만들 경우 상품전체를 했을때 
		ALL("ALL"),//모든 factor에 적용 all인경우 무조건 true로 pass
		UNDEFINED_FACTOR_VALUE("팩터미정의") // 팩터미정의, 정책엑셀업로드와 수수료실적조회 화면에서 사용
		;

		private String value;
		private SystemFactorValue(String value){
			this.value = value;
		}
		public String getValue(){
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	public enum FactorConvertKey {
	    FACTOR("FACTOR"),VALUE("VALUE"),ROLE("ROLE");
	    private String value;
	    private FactorConvertKey(String value) { this.value = value;}
	    public String getValue() { return this.value;}
	    public boolean isMatch(String compare) { return this.value.equals(compare);}
	}
	
	public enum Common {
		Y("Y"),
		N("N"),
		BYPASS("BYPASS"),
		UNSEL("UNSEL"),
		ALL("ALL"),
		EMPTY("EMPTY"),
		TOP("TOP"),
		LIMIT("LIMIT"),
		TRUE("true"),
		FALSE("false"),
		DUMMY("DUMMY"),
		EMPTY_STRING(""),
		ZERO("0"),
		MAX("MAX"),
		MIN("MIN"),
		SUM_STRING("합계");
		private String value;
		private Common(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	public enum PlcyLimit {
		MONTH("M"), YEAR("Y"), NONE("N"), ALL("A");
		private String value;
		private PlcyLimit(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	public enum RequestKey {
		META_DATA_TYPE("metadataType"),SERCURITY_KEY("securityYN"), BOOLEAN_Y_STRING("Y"),
		BOOLEAN_N_STRING("N"), CONTENT_TYPE_JSON("Application/json"), CONTENT_TYPE_XML("Application/xml"),
		CONTENT_TYPE_HTML("text/html"), CONTENT_TYPE_FILE("Application/octet-stream"), PARAM_KEY("data"), PARAMS("params");
		private String value;
		private RequestKey(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}		
	}
	
	public static class Policy{
		public enum PolicyStatus {
			APPROVAL("APPROVAL"), DISCARD("DISCARD"), TEMP("TEMP"), REQ("REQ");
			private String value;
			private PolicyStatus(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}	
		}
		public enum PolicyAction {
			ADD("ADD"), MODIFY("MODIFY"), FINAL_APPROVAL("FINAL_APPROVAL");
			private String value;
			private PolicyAction(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}	
		}
		public enum PolicyType {
			OLLEH("OLLEH"),
			VOC("VOC"),
			PRICE_GUIDE("PRICE_GUIDE"),
			MANAGEMENT("MANAGEMENT"),
			ADD_MANAGEMENT("ADD_MANAGEMENT"),//추가관리수수료 
			ARPU("ARPU"),
			BDGET_SECURING("BDGET_SECURING"),//예산확보정책.
			SL_PC_CMSSN("SL_PC_CMSSN"),//
			REJOIN("REJOIN"),//해지후재가입
			FEE_DIVISION("FEE_DIVISION"),
			HALF("HALF"),//반기별정책수수료 
			QUARTER("QUARTER"),//분기별정책수수료
			KT_PC_CMSSN("KT_PC_CMSSN"),//사내수수료
			OPNING_IN_ADVNC("OPNING_IN_ADVNC"); //선개통차감 정책
			private String value;
			private PolicyType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum RefundProcessType {
			RFD("RFD"), PAY("PAY");
			private String value;
			private RefundProcessType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum RefundType {
            OLLEH("OLLEH"),VOC("VOC"),VOC_AMT("VOC_AMT"),COMB_CHG("COMB_CHG"),COMB_TRMN("COMB_TRMN");
            
            private String value;
            private RefundType(String value) {
                this.value = value;
            }
            public String getValue() {
                return value;
            }
            public boolean isMatch(String compare) {
                return value.equals(compare);
            }
        }
		
		public enum RateCycleType {
			REAL("REAL"), BATCH("BATCH"), BOTH("BOTH"), NEXT_PROC("NEXT_PROC");
			private String value;
			private RateCycleType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum FactorInUsePolicy {
			PRODUCT(1320) // 단말기모델
		    ; 
			private int value;
			private FactorInUsePolicy(int value){
				this.value = value;
			}
			public int getValue(){
				return value;
			}
			public boolean isMatch(int compare) {
				return value == compare;
			}
		}
		
		public enum EndRateSettlementYm {
		    END_DATE("999912");
		    private String value;
		    private EndRateSettlementYm (String value) { this.value = value;}
		    public String getValue() { return this.value;}
		    public boolean isMatch(String compare) { return this.value.equals(compare);}
		}
		
		public enum SearchType {
			ORG_ID("ORG_ID"),
			ORG_NAME("ORG_NAME")
			;
			private String value;
			private SearchType(String value){
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	
	public static class PolicyTier {		
		public enum ConstraintType {
			AMOUNT_LIMIT("AMOUNT"), //금액제한유형 
			COUNT_LIMIT("COUNT"),//건수제한유형 
			MIN_CNT("MIN_CNT"),//최소실적건수제한 유형 main정책금을 주는데 단 추가조건이 만족하면 준다 ex)main 조건이 iphone4 면지급 단 lte> 4건 이상이면 main정책금지급 
			GOAL_RATON("GOAL_RATIO"),//목표달정률제한 유형 
			RATIO("RATIO"), //기본비율유형 조직이 아닌 UNIT당 accumulatedValue당 비율 
			BUFFER_RATIO("BUFFER_RATIO"); //버퍼율
			private String value;
			private ConstraintType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
	}
	
	public static class PolicyUnit {
		public enum PolicyUnitEnum {
			UNIT_NAME_DEFAULT_SUFFIX("_전체");
			private String value;
			private PolicyUnitEnum(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}

		public enum ApplyVolumeType {
			FIXED_RATIO("FIXED_RATIO"), FIXED_AMOUNT("FIXED_AMOUNT"),
			FREQUENCY("FREQUENCY");//도수 
			private String value;
			private ApplyVolumeType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		
		public enum TierType {
			FLAT("FLAT"), TIER("TIER"), STEP("STEP");
			private String value;
			private TierType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum AmountType {
			RATE("RATIO"), AMOUNT("AMOUNT"),
			REF_RATIO("REF_RATIO");
			private String value;
			private AmountType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	    
		public enum TierUnitType {
			IDENTIFY("IDENTIFY"), //개별식별 
			COMBINE_ORG("COMBINE_ORG"),//합산조직 
			AGENCY("AGENCY"),//처리점 
			CONTACT("CONTACT"),//접점
			UNITE("UNITE");//대리점(대리점 채권관계 유형) 
			private String value;
			private TierUnitType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum RatioTargetFactorId {
			FACTOR_ID_AGENCY_RATIO(1160); //대리점별 지급요율 
			private int value;
			private RatioTargetFactorId(int value) {
				this.value = value;
			}
			public int getValue() {
				return value;
			}
			public boolean isMatch(int compare) {
				return value == compare;
			}
		}
		
		public enum PolicyRefSalesCount {
			GUIDE("GUIDE"); 
			private String value;
			private PolicyRefSalesCount(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
	}
	
	public static class PolicyCondition {
		
		public enum TierFeeFlag {
			TIER_FLAG_INCLUSION("I"), TIER_FLAG_EXCLUSION("E"), FEE_FLAG_INCLUSION("I"), FEE_FLAG_EXCLUSION("E");
			private String value;
			private TierFeeFlag(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}

	}
	
	public static class PolicyConstraint {
		
		public enum OperationType {
			OR("OR"), AND("AND");
			private String value;
			private OperationType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}

		public enum NodeType {
			OPERAND("OPERAND"), OPERATOR("OPERATOR");
			private String value;
			private NodeType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}

		public enum ConstraintType {
			DEFAULT("DEFAULT"), RATIO("RATIO");
			private String value;
			private ConstraintType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}

	}
	
	public static class Settlement {
	    public static class Resource {
	        
	    	public enum SearchType {
	    		CACHE("CACHE"), DB("DB"), CACHE_DB("CACHE_DB");
				private String value;
				private SearchType(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}
	        
	    	public enum CacheMode {
	    		NOPAGE("NOPAGE"), PAGE("PAGE"), COMBI("COMBI");
				private String value;
				private CacheMode(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}
	        
	    	public enum PageAlogrithm {
	    		LRU("LRU"), LFU("LFU"), LIFO("LIFO");
				private String value;
				private PageAlogrithm(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}
	        
	    	public enum AccumulatorName {
	    		SIMPLE("SIMPE"), DUMMY("DUMMY");
				private String value;
				private AccumulatorName(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}

	    	public enum AccumulationType {
	    		DEFAULT("DEFAULT"), MULTI("MULTI"), DUMMY("DUMMY");
				private String value;
				private AccumulationType(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}

	    	public enum AccumulationState {
	    		COUNTING("COUNTING"), RATING("RATING");
				private String value;
				private AccumulationState(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}

	    	        
	        /**
	         * 보정BATCH TYPE (BATCH실행시 settlementContext 정보로 사용됨)
	         * <pre>
	         * com.kt.prm.common.support.util
	         * Constant.java
	         * </pre>
	         *
	         * @Company : KT 
	         * @Author  : sslee
	         * @Date    : 2012. 12. 18. 오후 6:07:37
	         * @Version : 1.0
	         */
	    	public enum AdjustBatchType {
	    		Y("Y"), //tire 보정 batch 
	    		NONE("NONE");//조정 batch 아님 
				private String value;
				private AdjustBatchType(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}
	    }
	    
	    public enum ReasonCode {
            RESTORATION("RESTORATION"),
            TERMINATION("TERMINATION"),
            CNCL("CNCL");
            private String value;
            private ReasonCode(String value) {
                this.value = value;
            }
            public String getValue() {
                return value;
            }
            public boolean isMatch(String compare) {
                return value.equals(compare);
            }
        }
	    
	    /**
         * Calculator type
         * <pre>
         * com.kt.prm.common.support.util
         * Constant.java
         * </pre>
         *
         * @Company : KT 
         * @Author  : sslee
         * @Date    : 2012. 12. 26. 오후 2:38:40
         * @Version : 1.0
         */
	    public enum CalculatorType {
	    	RATE("RATE"), REFUND("REFUND");
			private String value;
			private CalculatorType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}

	    public enum SettlementOperatorType {
	    	MULTIPLICATION("MULTIPLICATION"), REFUND_PERIOD_FORMULA("PERIOD_FORMULA"), REFUND_COMBINATION("CMB"), REFUND_ADD_SERVICE("ADD_SERVICE"), REFUND_CALPLAN("CALPLAN");
			private String value;
			private SettlementOperatorType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}

	    
	    /**
	     * 결산상태 코드 
	     * <pre>
	     * com.kt.prm.common.support.util
	     * Constant.java
	     * </pre>
	     *
	     * @Company : KT 
	     * @Author  : sslee
	     * @Date    : 2012. 7. 23. 오후 2:37:15
	     * @Version : 1.0
	     * 
	     */
	    public enum SettlementStateCode {
	    	NONE_STATE("NONE"), INDETERMINATE("INDETERMINATE"), QUOTATION_STATE("QUOTATION"), PAYMENT_STATE("PAID"), NONPAID_STATE("NONPAID"), 
	    	PORTION_REFUND_STATE("REFUND"), COMPLETION_REFUND_STATE("CMPLTN_REFUND"), NULLITY_STATE("NULLITY"), POSTPONEMENT_STATE("POSTPONEMENT"),EXCLUDE_FEE("EXCLUDE_FEE"),
	    	NOTALLOWLOB("NLB"),W_NOTALLOWLOB("WNB");
			private String value;
			private SettlementStateCode(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	    
	    public enum SettlementRefundType {
	    	NONE("NONE");
			private String value;
			private SettlementRefundType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}

	    /**
	     * 결산 상태코드
	     * @author kyung
	     *
	     */
	    public enum SettlementAcntCode{
	    	OLLEH_DECIDED("OLLEH_DECIDED"),       //올레감동에서 지급확정 : 금액 수납액1% - (수납액1%에서 65~100% = 판돈)
	    	OLLEH_MGT_PAY("OLLEH_MGT_PAY"), //올레감동에서 음성관리수수료 6.15 
	    	OLLEH_TRGT_AMT("OLLEH_TRGT_AMT"),//(수납액1%에서 65~100% = 판돈)
	    	OLLEH_DSTRT("OLLEH_DSTRT"),//올레분배금액
	    	VOC_TRGT_AMT("VOC_TRGT_AMT"),//(-2000 = 판돈)
	    	VOC_DSTRT("VOC_DSTRT"),//VOC분배금액 
	    	OLLEH("OLLEH"),//올레감동수수료계정코드 임시 추후에 결산계정 모듈에서 제공 할 예정
	    	VOC("VOC"),
	    	FIRST_TRANSFER("FIRST_TRANSFER"),  //첫번째 관리수수료 이관조직 
	    	SECOND_TRANSFER("SECOND_TRANSFER"),//두전째 관리수수료 이관조직 
	    	;
	    	private String value;
			private SettlementAcntCode(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
	    }
	    
	    /**
	     * 수수료분배유형 
	     * <pre>
	     * com.kt.prm.common.support.util
	     * Constant.java
	     * </pre>
	     *
	     * @Company : KT 
	     * @Author  : sslee
	     * @Date    : 2013. 1. 30. 오후 1:38:17
	     * @Version : 1.0
	     */
	    public enum DivideType {
	    	OLLEH("OLLEH"),//올레감동 
	    	VOC("VOC"),//VOC 차감 
	    	STATIC("STATIC");// 사용자 강제 분배 
	    	private String value;
	    	private DivideType(String value) { this.value = value;}
	    	public String getValue(){return value;}
	    	public boolean isMatch(String compare) {return value.equals(compare);}
	    }
	    
	    public enum TargetDataKey {
	        NEW("NEW"),
	        OLD("OLD"),
	        NEW_STLMNT("NEW_STLMNT"),
	        OLD_STLMNT("OLD_STLMNT"),
	        NEW_STLMNT_CHG("NEW_STLMNT_CHG"),
	        OLD_STLMNT_CHG("OLD_STLMNT_CHG");
	        
	        private String value;
            private TargetDataKey(String value) { this.value = value;}
            public String getValue(){return value;}
            public boolean isMatch(String compare) {return value.equals(compare);}
	    }
	    
	    public enum StlmntDivideOrgHolderKey {
	        TARGET_ORG("TARGET_ORG"),
	        DIVIDE_SET("DIVIDE_SET");
	        
	        private String value;
	        private StlmntDivideOrgHolderKey(String value) {
	            this.value = value;
	        }
	        public String getValue() {
	            return value;
	        }
	        public boolean isMatch(String compare) {
	            return value.equals(compare);
	        }
	    }
	}
	
	
	public enum FuntionKeyNum {
	    
	    STLMNT_ACMLTD("STLMNT_ACMLTD"),
	    S_ACMLTD_C("S_ACMLTD_C");
	    
	    private String value;
        private FuntionKeyNum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        public boolean isMatch(String compare) {
            return value.equals(compare);
        }
	}
	public static class Guide {
		
		public enum ReferenceDataType {
			ALONE("ALONE"), EMOTION("EMOTION"), MANAGEMENT("MANAGEMENT"), VOC("VOC");
			private String value;
			private ReferenceDataType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum Event {
			EVENT_TYPE_BY_OPEN("OPEN"), EVENT_TYPE_BY_PCS_OPEN("PCS_OPEN"), EVENT_TYPE_BY_WIRED_OPEN("WIRED_OPEN"),
			EVENT_TYPE_BY_BUNDLE("BUNDLE"),EVENT_TYPE_BY_PYMMTD_CHG("PYMMTD_CHG"),EVENT_TYPE_BY_ADD_SVC("PCS_ADD_SVC"),
			UNIT_TYPE_ORG("ORG"), UNIT_TYPE_CONTRACT("CONTRACT");
			private String value;
			private Event(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum EventState {
			COMPLETE("COMPLETE"),
			NOT_MAPPED("NOT_MAPPED"),
			FAIL("FAIL"),
			SUCCESS("SUCCESS");
			private String value;
			private EventState(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum EntryType{
			ENTRY_GOOD_MOD("ENTRY_GOOD_MOD"),
			ENTRY_EX_CHG("ENTRY_EX_CHG");
			private String value;
			private EntryType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum ReplicationFlag{
			ALL("A"),
			LITTLE("L"),
			NONE("N");
			private String value;
			private ReplicationFlag(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum ChildeType{
			GUIDE_DTL("G_DTL"),
			GUIDE_CHG("G_CHG");
			private String value;
			private ChildeType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
				
		public enum GuideDataVocFactor{			
			CONTACT_NUM("1"),
			TARGET_ORG("2"),
			EVENT_DATE("4"),
			SR("603"),
			TEL("606"),
			VOC_PRC_DATE("601"),
			STATUS("S");
			
			private String value;
			private GuideDataVocFactor(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public static class Message {
			
			public enum TransRole {
				START("START"), END("END"), FIRST("FIRST"), LAST("LAST"), ZIP_CODE("ZIP_CODE"), ORG("ORG"), OWNED_ORG("OWNED_ORG"), ORIG_DATE("ORIG_DATE");
				private String value;
				private TransRole(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}
			
			public enum MessageEnum {
				MESSAGE_TYPE_BY_OPEN("OPEN"), MESSAGE_TYPE_BY_ADD_SVC("ADD_SVC"), MESSAGE_TYPE_BY_PAYMENT("PAYMENT"), MESSAGE_TYPE_BY_WR_OPEN("WR_OPEN"), 
				MESSAGE_TYPE_BY_S_MATCHED("S_MATCHED"), MESSAGE_TYPE_BY_M_MATCHED("M_MATCHED"),MESSAGE_TYPE_BY_USED_AMT("USED_AMT"), MESSAGE_TYPE_BY_AFTMN_RESBS("AFTMN_RESBS"),
				MESSAGE_TYPE_BY_BOND("BOND"), MESSAGE_TYPE_BY_SRTT("SRTT"), MESSAGE_TYPE_BY_NONODR("NONODR"),MESSAGE_TYPE_BY_WRKJOB("WRKJOB"),
				MESSAGE_TYPE_BY_BUNDLE("BUNDLE"),
				TRANS_TYPE_BY_VOC_DTL("VOC_DTL"), TRANS_TYPE_BY_CUMULATE("CUMULATE"),
				TRANS_TYPE_BY_FACTOR("FACTOR"), TRANS_TYPE_BY_BYPASS("BYPASS"), TRANS_TYPE_BY_ORG_CHANNEL("ORG_CHANNEL"),
				TRANS_TYPE_BY_ORG("ORG"), TRANS_TYPE_BY_SALES_AREA("SALES_AREA"), TRANS_TYPE_BY_AGE("AGE"), TRANS_TYPE_BY_GENDER("GENDER"),
				TRANS_TYPE_BY_USED_DAY("USED_DAY"), TRANS_TYPE_BY_CHARGE_PRODUCT("CHARGE_PRD"), TRANS_TYPE_BY_ADD_SERVICE("ADD_SVC"), TRANS_TYPE_BY_PLACE("PLACE"),
				TRANS_TYPE_BY_ENTRY_TERM("ENTRY_TERM"), TRANS_TYPE_BY_ENTRY_TERM_Y("ENTRY_TERM_Y"), TRANS_TYPE_BY_ENTRY_TERM_M("ENTRY_TERM_M"),
				TRANS_TYPE_BY_ORG_OPTION("ORG_OPTION"), TRANS_TYPE_BY_PAYMENT_ITEM("PAYMENT_ITEM"), TRANS_TYPE_BY_PAID_TERM("PAID_TERM"), TRANS_TYPE_BY_PAID_TERM_TGT("PAID_TERM_TGT"),
				TRANS_TYPE_BY_REF_SERVICE("REF_SERVICE"), TRANS_TYPE_BY_MATCH_RESULT("MATCH_RESULT"), TRANS_TYPE_BY_MATCH_ORD("MATCH_ORD"), TRANS_TYPE_BY_MATCH_TYPE("MATCH_TYPE"),
				TRANS_TYPE_BY_CONTRACT("CONTRACT"), TRANS_TYPE_BY_OCCURS_DATE("OCCURS_DATE"), TRANS_TYPE_BY_ORG_HIST("ORG_HIST"), TRANS_TYPE_BY_COMPET_GROUP("COMPET_GROUP"),
				TRANS_TYPE_BY_MAIN_PRODUCT("MAIN_PRODUCT"),TRANS_TYPE_BY_HOLIDAY("HOLIDAY"), TRANS_TYPE_BY_PRE_DATA("PRE_DATA"), TRANS_TYPE_BY_AGNCY_TYPE("AGNCY_TYPE"),
				TRANS_TYPE_BY_MULTI_FACTOR("MULTI_FACTOR"), TRANS_TYPE_BY_COMBINE("COMBINE"), TRANS_TYPE_BY_ORG_MATCH("ORG_MATCH"),TRANS_TYPE_BY_ORG_CONTACT("ORG_CONTACT"),
				TRANS_TYPE_BY_CALL_SUM("CALL_SUM"), TRANS_TYPE_BY_CHRG_AMT("CHRG_AMT"), TRANS_TYPE_BY_USER_CHANNEL("USER_CHANNEL"),
				TRANS_TYPE_BY_WORK_TYPE("WORK_TYPE");
				private String value;
				private MessageEnum(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}

		}
		public static class Combine{
			public enum TransType {
			     COMBINE_TYPE("TYPE"), COMBINE_TARGET_LOB("TARGET_LOB"), 
			     COMBINE_ENTR_TYPE("ENTR_TYPE"), COMBINE_MANDATORY_LOB("MANDATORY_LOB"),
			     COMBINE_INFO("INFO"), COMBINE_MATCH("MATCH"),
			     COMBINE_PRODUCT("PRODUCT"), COMBINE_LOB("LOB"),
			     COMBINE_NEW_LOB("NEW_LOB");
			     ; 
				private String value;
				private TransType(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}
			
			public enum BundleType {
			     DPS("COMB_TYPE_DPS"), TPS("COMB_TYPE_TPS"), QPS("COMB_TYPE_QPS"), FPS("COMB_TYPE_FPS")
			     ; 
				private String value;
				private BundleType(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}
			
			public enum ProcessType {
			     ADD("ADD"), EXISTING("EXISTING"), DELETE("DELETE"),NONE("NONE")
			     ; 
				private String value;
				private ProcessType(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}
		}
	}
	
	public static class Process {
		public enum ProcessRefType {
			POLICY("POLICY"), // 정책
			SALES_MATCH("SALES_MATCH"), // 실적정합
			RE_ENTR("RE_ENTR"), // 해지후재가입
			PRE_OPEN_DEDUCTION("PRE_OPEN_DEDUCTION"), // 선개통차감
			SALES_MATCH_FORCED_PRF("SALES_MATCH_FORCED_PRF")// 실적정합 강제소명
			;
			private String value;
			private ProcessRefType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum ProcessDtlType {
			FORM_MATCH("FORM_MATCH"), // 서식지정합
			CHANNEL_MATCH("CHANNEL_MATCH") // 채널정합
			;
			private String value;
			private ProcessDtlType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum ProcessApprovalStatus {
			REQ("REQ"), REJECT("REJECT"), APPROVAL("APPROVAL"), CANCEL("CANCEL"), DISCARD("DISCARD");
			private String value;
			private ProcessApprovalStatus(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum ProcessConstraintType {
			APPROVAL("APPROVAL"), ORG_LEVEL("ORG_LEVEL"), FIXED_DATE("FIXED_DATE");
			private String value;
			private ProcessConstraintType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum ProcessFactor {
			SALES_MATCH_ORDER_FACTOR(1070), // 실적정합 조직 팩터
			SALES_MATCH_SVC_CONT_NO_FACTOR(1000), // 실적정합 서비스계약번호 팩터
			SALES_MATCH(2970), // 실적정합
			FORM_MATCH(2980), // 서식지정합
			CHANNEL_MATCH(2960) // 채널정합
			;
			private int value;
			private ProcessFactor(int value) {
				this.value = value;
			}
			public int getValue() {
				return value;
			}
			public boolean isMatch(int compare) {
				return value == compare;
			}
		}		
		public enum ProcessFactorValue {
			CRCT("CRCT"), // 정합
			PRF_RFT("PRF_RFT"), // 소명반영
			FTNS("FTNS"), // 적격
			EXCEPT_FTNS("EXCEPT_FTNS"), // 예외적격
			TRT_EXPT("TRT_EXPT"), // 대상제외
			NCRCT("NCRCT"), //부정합 
			UNREG("UNREG"), //미등록
			NSUST("NSUIT")	//부적격
			;
			private String value;
			private ProcessFactorValue(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}	
		public enum ProcessMessage {
			DISCARD("정책폐기로 인한 자동 폐기");
			private String value;
			private ProcessMessage(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	
	public static class Factor {
		
		public static class OrderProcessType {
			public enum Guide {
				GUIDE_DETAIL("G_DTL"), 
				GUIDE_CHANGE("G_CHG");
				private String value;
				private Guide(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}
			public enum Type {
				OPEN("ORD_PRC_OP"),
				MV_OPEN("ORD_PRC_MB_NV_OP"),//번호이동 신규 
				PAY_A("ORD_PRC_PAY_A"), //수납 
				OPEN_CANCEL("ORD_PRC_OP_CA"), // 개통취소 
				MODIFY("ORD_PRC_MD"), 
				MODIFY_CANCEL("ORD_PRC_MD_CA"), //기변취소 
				MB_CANCEL("ORD_PRC_MB_TRC"), //전환신규취소 
				PRODUCT_CANCEL("ORD_PRC_PD_CS"), // 부가서비스같은 상품취소 
				
				W_ACPT("ORD_PRC_W_AC"), //유선 접수 
				W_OPEN("ORD_PRC_W_OP"), //유선개통
				
				W_ACPT_CANCEL("ORD_PRC_W_AC_C"), //유선개통
				W_OPEN_CANCEL("ORD_PRC_W_OP_C"), //유선개통취소
				
				W_EM("ORD_PRC_W_EM"), //유선약정기간변경 
				
				PAY_CANCEL("ORD_PRC_PAY_C"), //수납취소
				PD_SM("ORD_PRC_PD_SM"), //요급제 변경 (상품변경코드)
				RESTORATION_REFUND("ORD_PRC_C_RC"), //해지복구
				
				NW_TRN("ORD_PRC_MB_NW_TRN"), //전환신규 
				
				ORD_PRC_WRK_VICEX_C("ORD_PRC_WRK_VICEX_C"),//업무대행 취소 
				ORD_PRC_MB_NV_RT("ORD_PRC_MB_NV_RT"), //번호이동 취소 
				ORD_PRC_MB_NW_RT("ORD_PRC_MB_NW_RT"), //신규개통취소 
				ORD_PRC_MB_RSP("ORD_PRC_MB_RSP"), //이용정지해제 
				ORD_PRC_MB_SUS("ORD_PRC_MB_SUS"), //이용정지 
				ORD_PRC_NM("ORD_PRC_NM"), //명의변경 
				ORG_PRC_MB_CHG("ORG_PRC_MB_CHG"), //번호변경
				ORD_PRC_C("ORD_PRC_C"), //개통해지
				CALL_HIST_READ("ORD_PRC_CALL_HST_RD"), //통화내역열람
				PRODUCT_ENTER("ORD_PRC_PD_SS"), //부가서비스가입
				ORD_PRC_COMB_NEW("ORD_PRC_COMB_NEW"),	//결합신규
				ORD_PRC_COMB_CHG("ORD_PRC_COMB_CHG"),	//결합변경
				ORD_PRC_COMB_TRMN("ORD_PRC_COMB_TRMN"),	//결합해지
				ORD_PRC_SRTT("ORD_PRC_SRTT"),			//실적정합 검증센터
				ORD_PRC_NONODR("ORD_PRC_NONODR"),	    //실적정합 논오더
				ORD_PRC_PAY_METH_CHG_GIRO("ORD_PRC_PAY_METH_CHG_GIRO"), // 납부방법변경(자동이체->지로)
				ORD_PRC_PD_OP("ORD_PRC_PD_OP"), // 요금제가입
				ORD_PRC_PD_C("ORD_PRC_PD_C") // 요금제해지
				;

				private String value;
				private Type(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
			}

		}
		
		public enum FactorRelationType {
			MPD("MPD");
			private String value;
			private FactorRelationType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum FactorRole {
			 KEY("KEY"), 
			 ORG("ORG"),
			 PTNR_CH("PTNR_CH"),
			 CHANNEL("CHANNEL"),
			 MAIN_PRODUCT("MAIN_PRODUCT"),
			 ORG_CHANNEL("ORG_CHANNEL"), 
			 PRODUCT("PRODUCT"), 
			 CALLPLAN("CALLPLAN"), 
			 PROCESS("PROCESS"), 
			 ORIGINATION_DATE("ORIG_DATE"), 
			 ADD_FILTER("ADD_FILTER"), 
			 ACCUM("ACCUM"), 
			 LOB("LOB"), 
			 SUB_AGENCY("SUB_AGENCY"), 
			 VERIFY_RESULT("VERIFY_RESULT"), 
			 VERIFY_ALL("VERIFY_ALL"), 
			 VERIFY_TYPE("VERIFY_TYPE"),
			 IMEI("IMEI"),
			 ENTRY_TYPE("ENTRY_TYPE"),
			 INTL_SEC("INTL_SEC"),
			 NTNL_SEC("NTNL_SEC"),
			 INTL_CNT("INTL_CNT"),
			 NTNL_CNT("NTNL_CNT"),
			 TOTAL_CALL_CNT("TOTAL_CALL_CNT"),
			 TOTAL_CALL_AMT("TOTAL_CALL_AMT"),
			 AFTMN_RESBS("AFTMN_RESBS"),
			 ENTR_TERM_MONTH("ENTR_TERM_MONTH"),
			 ORG_TYPE("ORG_TYPE"),
			 FIRST_ENTR_DT("FIRST_ENTR_DT"),
			 HANDSET_TYPE("HANDSET_TYPE"),
			 OPTION("OPTION"),
			 OPTION_PAID_YN("OPTION_PAID_YN"),
			 NEW_BUILD("NEW_BUILD"),
			 BUILD_TYPE("BUILD_TYPE"),
			 CUMUL_TYPE("CUMUL_TYPE"),
			 FEATURE_TYPE("FEATURE_TYPE"),
			 USED_DAYS("USED_DAYS"),
			 GOOD_MD_ORG("GOOD_MD_ORG"),
			 EXCPT_YN("EXCPT_YN"),
			 EXCPT_DT("EXCPT_DT"),
			 PRE_HNDST("PRE_HNDST"),
			 PRE_CALLPLAN("PRE_CALLPLAN"),
			 REF("REF"),
			 VERIFY_REASON("VERIFY_REASON"),
			 STRTG_BUILD("STRTG_BLDG"),
			 STRTG_RGN("STRTG_RGN"),
			 UP_BUILD("UP_BLDG"),
			 SERVICE_DAY("SERVICE_DAY"),
			 ACPT_DATE("ACPT_DATE"),
			 STOP_DAYS("STOP_DAYS"),
			 CHANNEL_MATCH("CHANNEL_MATCH"),
			 SALES_MATCH("SALES_MATCH"),
			 FORM_MATCH("FORM_MATCH"),
			 FORM_REG_YN("FORM_REG_YN"),
			 FORM_REG_DT("FORM_REG_DT"),
			 FORM_REQ_YN("FORM_REQ_YN"),
			 MATCH_WORK_DT("MATCH_WORK_DT"),
			 VERIFY_STATUS("VERIFY_STATUS"),
			 S_NOTE_SUB_AGENCY("S_NOTE_SUB_AGENCY"),
			 VERIFY_TERM("VERIFY_TERM"),
			 BUNDLE_NEW_LOB("BUNDLE_NEW_LOB"),
			 BUNDLE_ORG_MATCH("BUNDLE_ORG_MATCH"),
			 BUNDLE_SELLER_MATCH("BUNDLE_SELLER_MATCH"),
			 SELLER("SELLER"),
			 BUNDLE_CALLPLAN("BUNDLE_CALLPLAN"),
			 BUNDLE_HANDSET("BUNDLE_HANDSET"),
			 BUNDLE_PROCESS_TYPE("BUNDLE_PROCESS"),
			 BUNDLE_RCP_DT("BUNDLE_RCP_DT"),
			 BUNDLE_PRC_DT("BUNDLE_PRC_DT"),
			 OPEN_DATE("OPEN_DATE"),
			 BUNDLE_MAND_LOB("BUNDLE_MAND_LOB"),
			 PARENT_ORG_MATCH("PARENT_ORG_MATCH"),
			 PRODUCT_HIST_SEQ("PRODUCT_HIST_SEQ"),
			 MANAGE_PAID_TYPE("MANAGE_PAID_TYPE"),
			 FORM_ID("FORM_ID"),
			 VERIFY_DATE("VERIFY_DATE"),
			 VERIFY_RESULT_DTL("VERIFY_RESULT_DTL"),
			 FORM_REG_PATH("FORM_REG_PATH"),
			 VERIFY_DIV("VERIFY_DIV"),
			 VERIFY_DISPOSER("VERIFY_DISPOSER"),
			 CPNT_MTCH_YN("CPNT_MTCH_YN"),
			 WRKJOB_DIV("WRKJOB_DIV"),
			 VERIFY_TGT_YN("VERIFY_TGT_YN"),
			 OLLEH("OLLEH"),
			 CANCEL_YN("CANCEL_YN"),
			 SUM_CHARGE_AMT("SUM_CHRG_AMT"),
			 ACCUM_TARGET("ACCUM_TGT"),
			 PRC_ORG("PRC_ORG"),
			 OPEN_TERM_MONTH("OPEN_TERM_MONTH"),
			 BAN("BAN"),
			 FCLT_DIV_CD("FCLT_DIV_CD"),
			 M2M_HNDSET_YN("M2M_HNDSET_YN"),
			 USE_TERM_YEAR("USE_TERM_YEAR"),
			 BUNDLE_SELLER("BUNDLE_SELLER"),
			 BUNDLE_FEE_TARGET("BUNDLE_FEE_TARGET"),
			 BUNDLE_KEEP_MONTH("BUNDLE_KEEP_MONTH"),
			 BUNDLE_ORG("BUNDLE_ORG"),
			 BUNDLE_INFO("BUNDLE_INFO"),
			 BUNDLE_ACCUM("BUNDLE_ACCUM"),
			 BUNDLE_SUB_AGENCY("BUNDLE_SUB_AGENCY");
			private String value;
			private FactorRole(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum RefundFactorRole {
//		     CONDITION("CONDITION"), 
//		     COMPARE_TARGET("COMPARE_TARGET"), 
		     CONDITION("P"), 
             COMPARE_TARGET("G"), 
             STLMNT("S"), 
             REF_TARGET("R"),
		     FEE_TARGET("FEE_TARGET"), 
		    
		     CONDITION_NM("정책"), 
             COMPARE_TARGET_NM("실적"), 
             STLMNT_NM("수수료"),
		     REF_TARGET_NM("자료참조");
		     
 			private String value;
 			private RefundFactorRole(String value) {
 				this.value = value;
 			}
 			public String getValue() {
 				return value;
 			}
 			public boolean isMatch(String compare) {
 				return value.equals(compare);
 			}
		}
//		public enum SalesFactor {
//			 FACTOR_ID_BY_CONTRACT("1"), 
//			 FACTOR_ID_BY_ORG("2"), 
//			 FACTOR_ID_BY_PRODUCT("3"), 
//			 FACTOR_ID_BY_ORDER_PROC_TYPE("8"), 
//			 FACTOR_ID_BY_ENTRY_DATE("4"), 
//			 FACTOR_ID_BY_REAL_USE_DATE("14");
//			private String value;
//			private SalesFactor(String value) {
//				this.value = value;
//			}
//			public String getValue() {
//				return value;
//			}
//			public boolean isMatch(String compare) {
//				return value.equals(compare);
//			}
//		}
		
		public enum RateProcessType {
		     RATE_PROCESS_TYPE_AD_RFD("AD_RFD"), //부가서비스만 환수 
		     RATE_PROCESS_TYPE_AD_PAY("AD_PAY"), //부가서비스만 지급 
		     RATE_PROCESS_TYPE_PAY("PAY"), //개통(main + 부가서비스)
		     RATE_PROCESS_TYPE_RFD("RFD"), //환수(main + 부가서비스)
		     RATE_PROCESS_TYPE_NONE("NONE"); //결산상관 없는 TYPE
			private String value;
			private RateProcessType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum SeekType {
		     EXACT("EXACT"), //일치 
		     REF_ORG("REF_ORG"),//참조조직 
		     HIERARCHY("HIERARCHY"); //계층 
				private String value;
				private SeekType(String value) {
					this.value = value;
				}
				public String getValue() {
					return value;
				}
				public boolean isMatch(String compare) {
					return value.equals(compare);
				}
		}
		
		public enum FactorRefType {
		     ORG("ORG"), 
		     ORG_CHANNEL("ORG_CHANNEL"), 
		     FACTOR_VALUE("FACTOR_VALUE"), 
		     LOB("LOB"), 
		     PRODUCT("PRODUCT"),
		     GROUP("GROUP"),
		     ORG_GROUP("ORG_GROUP"),
		     HOLIDAY("HOLIDAY"),
		     BUILDING("BUILDING"),
		     NONE("NONE"),
		     LOCATION("LOCATION"),
		     PAYMENT_ITEM("PAYMENT_ITEM"),
		     BNDL_GRP("BNDL_GRP"),
		     ORG_CONTACT("ORG_CONTACT")
		     ; 
			private String value;
			private FactorRefType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum FactorKey{
			GENDER_TYPE("GENDER_TYPE"),
			 PRODUCT("PRODUCT"), 
			 ADD_SERVICE("ADD_SERVICE"), 
			 CALL_PLAN("CALL_PLAN"), 
			 CHARGE_PROUDCT("CHARGE_PROUDCT"), 
			 PRODUCT_ID("PRODUCT_ID"), 
			 WIRED_MDL("WIRED_MDL"),
			 PROMOTION("PROMOTION"),
			 ENTRY_ORG_ID("ENTRY_ORG_ID"),
			 PRC_ORG_ID("PRC_ORG_ID");
			private String value;
			private FactorKey(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum FactorValue {
			 MODE_BY_SEARCH("search"), 
			 LIST_BY_FACTOR("factor"),
			 MODE_BY_CHILD("child");
			private String value;
			private FactorValue(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum FactorType {
			 RATIO("RATIO"),
			 CONDITION("CONDITION");
			private String value;
			private FactorType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
	}
	
	/**
	 * settlementType 
	 * <pre>
	 * com.kt.prm.common.support.util
	 * Constant.java
	 * </pre>
	 *
	 * @Company : KT 
	 * @Author  : sslee
	 * @Date    : 2012. 4. 24. 오후 3:21:23
	 * @Version : 1.0
	 */
	public enum SettlementType {
		SALES_SETTLEMENT_TPYPE_ID(1),
		MANAGEMENT_SETTLEMENT_TPYPE_ID(2),
		AGENCY_SETTLEMENT_TPYPE_ID(3),//업무대행수수료(
		ADD_SERVICE_SETTLEMENT_TYPE_ID(4),
		SALES_MATCHING_SETTLEMENT_TYPE_ID(5), //실적정합수수료
		BOND_SUCC_SETTLEMENT_TYPE_ID(6), //채권승꼐수수료
		ATYPICAL_SETTLEMENT_TYPE_ID(7),		  //비정형수수료
		G_SALES_SETTLEMENT_TPYPE_ID(1000),
		G_MANAGEMENT_SETTLEMENT_TPYPE_ID(2000),
		G_AGENCY_SETTLEMENT_TPYPE_ID(3000),//업무대행수수료(
		G_ADD_SERVICE_SETTLEMENT_TYPE_ID(4000),
		AFTER_OPEN_DEDUCTION(10),//선개통 후 차감 
		AFTER_CANCEL_RE_OPEN(11);//해지 후 재가입 
		;
		
		private int value;
		private SettlementType(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public boolean isMatch(int compare) {
			return value == compare;
		}
		public enum factorRole {
			KEY("KEY"), 
			PROCESS("PROCESS"), 
			ACCOUNT("ACCOUNT");
			private String value;
			private factorRole(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	    public enum GuideSeparator {
	    	 MUTATOR("MUTATOR"),
	    	 FACTOR_ACCOUNT("FACTOR_ACCOUNT"),
	    	 ORDER_PROC("ORDER_PROC"),
	    	 ORDER_PROC_DAY("ORDER_PROC_DAY");
			private String value;
			private GuideSeparator(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
	    }
	}
	
	/**
	 * 결산에서 개통,해지,기변 등의 상태에 따른 계산분류를 위한 코드값 
	 * <pre>
	 * com.kt.prm.common.support.util
	 * Constant.java
	 * </pre>
	 *
	 * @Company : KT 
	 * @Author  : sslee
	 * @Date    : 2012. 4. 26. 오후 3:58:22
	 * @Version : 1.0
	 */
	public enum SettlementEntryType {
	     SALES_ENTRY("SALES_ENTRY"), 
	     SALES_CANCEL("SALES_CANCEL");
		private String value;
		private SettlementEntryType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	/**
	 * 결산처리시 새로 등록 할지 갱신할지의 flag 상수 
	 * <pre>
	 * com.kt.prm.common.support.util
	 * Constant.java
	 * </pre>
	 *
	 * @Company : KT 
	 * @Author  : sslee
	 * @Date    : 2012. 6. 25. 오전 10:31:26
	 * @Version : 1.0
	 */
	public enum SettlementProcessType {
	     EXECUTE_ADD("I"), 
	     EXECUTE_UPDATE("U"), 
	     SKIP("S");
		private String value;
		private SettlementProcessType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	/**
	 * 현재 가입,해지,중지 상태 코드 
	 * <pre>
	 * com.kt.prm.common.support.util
	 * Constant.java
	 * </pre>
	 *
	 * @Company : KT 
	 * @Author  : sslee
	 * @Date    : 2012. 5. 2. 오후 1:45:08
	 * @Version : 1.0
	 */
	public enum SettlementEntryStatus {
	     ENTRY("E"), 
	     CANCEL("C"), 
	     HOLD("H");
		private String value;
		private SettlementEntryStatus(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	/**
	 * 결산 금액 변동 reason code
	 * <pre>
	 * com.kt.prm.common.support.util
	 * Constant.java
	 * </pre>
	 *
	 * @Company : KT 
	 * @Author  : sslee
	 * @Date    : 2012. 5. 29. 오전 10:22:50
	 * @Version : 1.0
	 */
	public enum SettlementAmountReasonCode {
	     ENTR("ENTR"), 
	     STP("STP"), 
	     TIER_UP("TRUP"), 
	     TIER_DOWN("TRDN"), 
	     STEP_UP("STUP"), 
	     STEP_DOWN("STDN"), 
	     CANCEL("CNCL"),
	     MANAGEMENT("MANAGEMENT"),
	     ADJT("ADJT"), 				//조정수수료, 티어 상승과 하락을 둘다 반영함.
	     TRANS_FEE("TRANS_FEE");
		private String value;
		private SettlementAmountReasonCode(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	public static class Org {
		public enum RelationType {
			 ORG_OF_CA("ORG_OF_CA"),
			 ORG_OF_TR("ORG_OF_TR"),
			 KT("KT"), 
			 MNS("MNS"),
			 UNITE("UNITE");
			private String value;
			private RelationType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum OrgLevel {
			 HR("700"), 
			 AGENCY("800"),
			 UNDECIDED_ORG("UNDECIDED_ORG"),
			 CONTACT("900");
			private String value;
			private OrgLevel(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum OrgChannel {
			PARTNER_CHANNEL("PARTNER_CHANNEL"), 
			SALE_CHANNEL("SALE_CHANNEL");
			private String value;
			private OrgChannel(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	
	public enum ProductType{
		 ADDSERVICE("ADDSERVICE"), 
		 PRODUCT("PRODUCT"), 
		 CALLPLAN("CALLPLAN"),
		 DISCOUNT("DISCOUNT"),
		 PROMOTION("PROMOTION"),
		 GIFT("GIFT"),
		 DEVICE("DEVICE"),
		 DUMMY("DUMMY");
		private String value;
		private ProductType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	public static class Group {
		public enum GroupType {
			 ORG("ORG"), 
			 PRODUCT("PRODUCT"),
			 COMBINE("COMBINE"),
			 COMPETING_GROUPS("COMPETING"),
			 M2M_GROUP("M2M_GRP");
			private String value;
			private GroupType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	
	public enum FeatureType {
		TEMP("TEMP"); //음성
		private String value;
		private FeatureType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	
	public static class AccumulatedData {
		public enum AccumCode {
			ORG("ORG"), 
			NOT_USED("NOT_USED"),
			MONTHLY("00000000"), 
			ALL("99999999"),
			COMBI_TYPE("COMBI_TYPE"),
			COMBI_LOB("COMBI_LOB");
			private String value;
			private AccumCode(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum DataType {
			 GUIDE("GUIDE"), 
			 RATE("RATE"); 
			private String value;
			private DataType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum DataTypeDetail {
			 ORG("ORG"), 
			 ACCOUNT("ACCOUNT"), 
			 POLICY("POLICY"),
			 ORDER("1070")
			 ; 
			private String value;
			private DataTypeDetail(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum TargetDataType {
			NEW("NEW"), VOC("VOC");
			private String value;
			private TargetDataType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum StlmntAmounDataType{
			DETAIL("DETAIL"),CHANGE("CHANGE");
			private String value;
			private StlmntAmounDataType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}

	}
	
	public static class Refund {
		public enum CompareType {
			PRE("PRE"),
			DOWN("DOWN"); 
			private String value;
			private CompareType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	public enum Soap {
		Temp(11);//해지 후 재가입 
		
		private int value;
		private Soap(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public boolean isMatch(int compare) {
			return value == compare;
		}
		public enum Header {
			SuccessCode("N0000"), 
			SuccessMsg("Success"), 
			FailCode("E0000");
			private String value;
			private Header(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum Mdm {
			Success("000"), 
			Fail("800");
			private String value;
			private Mdm(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	    public enum GuideSeparator {
	    	 MUTATOR("MUTATOR"),
	    	 FACTOR_ACCOUNT("FACTOR_ACCOUNT"),
	    	 ORDER_PROC("ORDER_PROC"),
	    	 ORDER_PROC_DAY("ORDER_PROC_DAY");
			private String value;
			private GuideSeparator(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
	    }
	}
	public static class SetlProcessUnit {
		public enum UnitType {
			ORG("ORG"),
			COMBIN_ORG("COMBIN_ORG"); 
			private String value;
			private UnitType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum ProcessUnitState {
			READY("READY"),PROGRESS("PROGRESS");
			private String value;
			private ProcessUnitState(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum ProcessUnitValue {
			SINGLE("SINGLE"),
			S_SINGLE("S_SINGLE");
			private String value;
			private ProcessUnitValue(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	public static class CommissionResult {
		public enum OrgDvCd {
			HR("HR"),
			ORG_INCLUDED_SUBORG("ORG_INCLUDED_SUBORG"),
			UNDECIDED_ORG("UNDECIDED_ORG"); 
			private String value;
			private OrgDvCd(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	
	public static class SetlJobRequest {
		public enum JobType {
			DISCARD("DISCARD"),RETROACTIVE("RETROACTIVE"),CONFIRM("CONFIRM");
			private String value;
			private JobType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum JobStatus {
			READY("READY"),PROGRESS("PROGRESS"),FAIL("FAILED"),COMPLETE("COMPLETED"),SETL_COMPLETED("SETL_COMPLETED"),NULL_SETL("NULL_SETL");
			private String value;
			private JobStatus(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum TargetType {
			POLICY("POLICY"),SCAN_START_DATE("SCAN_START_DATE"),SCAN_END_DATE("SCAN_END_DATE"),TARGET_YM("TARGET_YM");
			private String value;
			private TargetType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum JobCycle {
			MONTHLY("MONTHLY"),DAILY("DAILY"), NEAR_REAL("NEARREAL"), ON_DEMAND("ONDEMAND");
			private String value;
			private JobCycle(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum JobParameter {
			NONE("NONE"),
			SETTLEMENT_YM("SETTLEMENT_YM"),
			JOB_CYCLE("JOB_CYCLE"),
			CYCLE_VALUE("CYCLE_VALUE"),
			PROCESS_UNIT("PROCESS_UNIT"),
			PROCESS_UNIT_TYPE("PROCESS_UNIT_TYPE"),
			PROCESS_UNIT_SUB_TYPE("PROCESS_UNIT_SUB_TYPE"),
			PROCESS_UNIT_STATE("PROCESS_UNIT_STATE"),
			SCAN_START_DATE("SCAN_START_DATE"),
			SCAN_END_DATE("SCAN_END_DATE"),
			SETTLEMENT_TYPE_ID("SETTLEMENT_TYPE_ID"),
			LOB("LOB"),
			IS_INIT("IS_INIT"),
			IS_SINGLE("IS_SINGLE");
			
			private String value;
			private JobParameter(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum JobId {
			DISCARD("BB2C-PRM-O-STL-NULLITYREQ"),
			RETROACTIVE("BB2C-PRM-O-STL-RTRSTLMNT"),
			CONFIRM("BB2C-PRM-O-STL-CONFIRM");
			
			private String value;
			private JobId(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	
	public static class SalesMatch {
		public enum SalesMatchBas {
			SALES_MATCH_TYPE_CD_BASIC("A10"),
			SALES_MATCH_TYPE_CD_UNREG("B10"),
			SALES_MATCH_TYPE_CD_UNREG_USED_ADVANCEPAYMENT("B20"),
			CHANNEL_TYPE_RETAIL("A100"),
			CHANNEL_TYPE_NOTRETAIL("B200");
			private String value;
			private SalesMatchBas(String value){
				this.value = value;
			}
			public String getValue(){
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum SalesMatchFactor {
			FRMPAP_CRCT_RESLT(2980), // 서식지정합결과
			FORM_REG_PATH(1450), // 서식지등록경로
			CH_CRCT_RESLT(2960), // 채널정합결과
			ACRU_CRCT_RESLT(2970), // 실적정합결과
			ENTRY_TYPE(1040), // 가입유형
			PRODUCT(1320), // 단말기모델
			UN_FIT_REASON(1430) // 서식지부격적사유
		     ; 
			private int value;
			private SalesMatchFactor(int value){
				this.value = value;
			}
			public int getValue(){
				return value;
			}
			public boolean isMatch(int compare) {
				return value == compare;
			}
		}
		public enum SalesMatchChannel {
			UNDEFINED("UNDEFINED"),
			UNDEFINED_NM("채널없음"),
			RETAIL_PATH("/1/11/114"),
			RETAIL("RETAIL"),
			RETAIL_NM("소매"),
			NOTRETAIL("NOTRETAIL"),
			NOTRETAIL_NM("소매외")
			;
			private String value;
			private SalesMatchChannel(String value){
				this.value = value;
			}
			public String getValue(){
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	
	public static class PrmJob {
		
		public enum Parameter {
			SETTLEMENT_YM("SETTLEMENT_YM"),
			ORG_ID("ORG_ID"),
			SETTLEMENT_TYPE_ID("SETTLEMENT_TYPE_ID"),
			SCAN_START_DATE("SCANSTARTDATE"),
			SCAN_END_DATE("SCANENDDATE"),
			LOB("LOB"),
			POLICY_ID("POLICY_ID"),
			PROCESS_UNIT_TYPE("PROCESS_UNIT_TYPE"),
			JOB_CYCLE("JOB_CYCLE"),
			CYCLE_VALUE("CYCLE_VALUE"),
			ORG_RELATION_TYPE("ORG_RELATION_TYPE"),
			IS_ADJUST_JOB("IS_ADJUST_JOB"),
			REFUND_PERIOD_MONTH("REFUND_PERIOD_MONTH"),
			ACCUMULATION_TYPE("ACCUMULATION_TYPE"),
			WORK_TYPE_CODE("WORK_TYPE_CODE"),
			SKIP("SKIP"),
			GUIDE_DATA_ID("GUIDE_DATA_ID");
			
			private String value;
			
			private Parameter(String value) { this.value = value;}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum StepStatus {
		    CONTINUE("CONTINUE"),
		    END("END");
		    
		    private String value;
            
            private StepStatus(String value) { this.value = value;}
            public String getValue() {
                return value;
            }
            public boolean isMatch(String compare) {
                return value.equals(compare);
            }
		}
	}
	
	public enum RefreshType {
		DEFAULT("DEFAULT"),
		NEAR_REAL("NEAR_REAL"),
		DAILY("DAILY"),
		MONTHLY("MONTHLY");
		
		private String value;
		
		private RefreshType(String value) { this.value = value;}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
		
	}
	
	public enum CacheKey {
		ACCUM_DATA("ACCUM_DATA"),
		ORG("ORG"),
		ORG_DATA("ORG_DATA"),
		CHANNEL("CHANNEL"),
		ORG_RELATIONS("ORG_RELATIONS"),
		ORG_RELATION("ORG_RELATION"),
		CHANNEL_RELATION("CHANNEL_RELATION"),
		ORG_CHANNEL("ORG_CHANNEL"),
		ORG_CHANNEL_REL("ORG_CHANNEL_REL"),
		ORG_RELATION_LIST("ORG_RELATION_LIST"),
		GROUP("GROUP"),
		HOLIDAY("HOLIDAY"),
		LOCATION("LOCATION"),
		BUILDING("BUILDING"),
		PLACE("PLACE"),
		FACTOR("FACTOR"),
		PRODUCT("PRODUCT"),
		PAYMENT_ITEM("PAYMENT_ITEM"),
		PRODUCT_PRICE("PRODUCT_PRICE"),
		REFUND_TYPE("REFUND_TYPE"),
		FACTOR_ACCOUNT("FACTOR_ACCOUNT"),
		FACTOR_ACCOUNT_SPEC("FACTOR_ACCOUNT_SPEC"),
		FACTOR_RELATION("FACTOR_RELATION"),
		ORG_REF_FACTOR("ORG_REF_FACTOR"),
		ORG_REF_SETTLEMENT_TYPE("ORG_REF_SETTLEMENT_TYPE"),
		POLICY_TYPE("POLICY_TYPE"),
		POLICY_RESOURCE("POLICY_RESOURCE"),
		POLICY_RESOURCE_LRU("POLICY_RESOURCE_LRU"),
		LOB_FACTOR("LOB_FACTOR"),
		CHANGE_REQ_DATA("CHANGE_REQ_DATA"),
		MSG_COLUMN("MSG_COLUMN"),
		MSG_FACTOR("MSG_FACTOR"),
		MSG_GROUP("MSG_GROUP"),
		EVENT_COLUMN("EVENT_COLUMN"),
		MSG_TYPE("MSG_TYPE"),
		FEE_STATE("FEE_STATE"),
		SETTLEMENT_ACCOUNT("SETTLEMENT_ACCOUNT"),
		SETTLEMENT_TYPE_LIST("SETTLEMENT_TYPE_LIST"),
		SETTLEMENT_TYPE_SPEC_LIST("SETTLEMENT_TYPE_SPEC_LIST"),
		FACTOR_KEY("FACTOR_KEY"),
		ACCOUNT_KEY("ACCOUNT_KEY"),
		MSG_SETL_TYPE_SPEC("MSG_SELT_TYPE_SPEC"),
		TRANSFER("TRANSFER"),
		TRANSFER_LIST("TRNASFER_LIST"),
		CODE("CODE"),
		EVENT_SPEC("EVENT_SPEC"),
		SETTLEMENT_YM("SETTLEMENT_YM"),
		POLICY_RESOURCE_PARAM("POLICY_RESOURCE_PARAM"),
		SALES_MATCH("SALES_MATCH"),
		SALES_MATCH_INFO("SALES_MATCH_INFO"),
		M2M_GROUP("M2M_GRP"),
		LOCATION_BUILDING("LOCATION_BUILDING"),
		SETTLEMENT_STATUS_AUTO_TRANSITION_YN("SETTLEMENT_STATUS_AUTO_TRANSITION_YN"),
		EVENT_WEBSERVICE_HOLD_YN("EVENT_WEBSERVICE_HOLD_YN")
		;
		private String value;
		
		private CacheKey(String value) { this.value = value;}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	public static class SalesResult {
		public enum SalesResultSearchType {
			SUB_ORG("SUB_ORG"),
			AGENCY("AGENCY"),
			INDIVIDUAL_ORG("INDIVIDUAL_ORG"),
			MODEL("MODEL"),
			CHANNEL("CHANNEL");
		
			private String value;
			
			private SalesResultSearchType(String value) { this.value = value;}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	
	public static class web{
		public enum screenType {
			BUDGET_POLICY("BUDGET_POLICY"), COMMISSION_SALES("COMMISSION_SALES"), SETTELEMNT_ACCOUNT("SETTELEMNT_ACCOUNT");
			private String value;
			private screenType(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}	
		}
	}
	public static class Batch{
		public enum Param {
			jobParam_RetryTarget("jobParam_retryTarget")
			, retryTarget("retryTarget")
			, runningJobType("runningJobType")
			, jobParam_settlement_ymd("jobParam_settlement_ymd")
			, settlement_ymd("settlement_ymd")
			, jobType("jobType")
			, ranJobTypes("ranJobTypes")
			, scanStartDate("scanStartDate")
			, scanEndDate("scanEndDate")
			, reqType("reqType")
			, settlementYm("settlementYm")
			, reqBdgetOrgId("reqBdgetOrgId")
			, reqDeptId("reqDeptId")
			, reqLobId("reqLobId")
			, reqSettlementTypeId("reqSettlementTypeId")
			, failed("failed")
			, downloadReqSeq("downloadReqSeq")
			, sheetLimit("sheetLimit")
			, rowLimit("rowLimit")
			, reqTargetDate("reqTargetDate")
			;
			
			private String value;
			private Param(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}	
		}
		public enum Status {
			  IS_END("IS_END")
			, DELETE("DELETE")
			, DELETE_AND_QUIT("DELETE_AND_QUIT")
			, CONTINUE("CONTINUE")
			, END("END")
			;
			private String value;
			private Status(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}	
		}
		public enum ColumnName {
			  JOBTYPE("JOBTYPE")
			, EAI_SEQ("EAI_SEQ")
			, EAI_STTUS_CD("EAI_STTUS_CD")
			, EAI_TRT_DIV_CD("EAI_TRT_DIV_CD")
			, BASE_YM("BASE_YM")
			, ORG_ID("ORG_ID")
			, LOB_ID("LOB_ID")
			, SBSC_TYPE_CD("SBSC_TYPE_CD")
			, AGNCY_ACRU_CASCNT("AGNCY_ACRU_CASCNT")
			, TRT_DATE("TRT_DATE")
			, WRKJOB_TRTR_ID("WRKJOB_TRTR_ID")
			, ACRU_DIV_CD("ACRU_DIV_CD")
			, TRT_CASCNT("TRT_CASCNT")
			, TRT_USER_ID("TRT_USER_ID")
			, SYS_RECD_CRET_DT("SYS_RECD_CRET_DT")
			
			, BASE_DATE("BASE_DATE")
			, ACRU_AGNCY_ID("ACRU_AGNCY_ID")
			, ACCUM_NEW_SBSCR_CASCNT("ACCUM_NEW_SBSCR_CASCNT")
			, ACCUM_TRMN_SBSCR_CASCNT("ACCUM_TRMN_SBSCR_CASCNT")
			, ACCUM_AGNCY_CHG_INC_CASCNT("ACCUM_AGNCY_CHG_INC_CASCNT")
			, ACCUM_AGNCY_CHG_DCRS_CASCNT("ACCUM_AGNCY_CHG_DCRS_CASCNT")
			, ACCUM_OPN_CNCL_SBSCR_CASCNT("ACCUM_OPN_CNCL_SBSCR_CASCNT")
			, ACCUM_ICG_SBSCR_CASCNT("ACCUM_ICG_SBSCR_CASCNT")
			, ACCUM_ICG_CNCL_SBSCR_CASCNT("ACCUM_ICG_CNCL_SBSCR_CASCNT")
			, TDAY_NEW_CASCNT("TDAY_NEW_CASCNT")
			, TDAY_TRMN_CASCNT("TDAY_TRMN_CASCNT")
			, TDAY_AGNCY_CHG_INC_CASCNT("TDAY_AGNCY_CHG_INC_CASCNT")
			, TDAY_AGNCY_CHG_DCRS_CASCNT("TDAY_AGNCY_CHG_DCRS_CASCNT")
			, TDOP_CNCL_SBSCR_CASCNT("TDOP_CNCL_SBSCR_CASCNT")
			, TDAY_ICG_SBSCR_CASCNT("TDAY_ICG_SBSCR_CASCNT")
			, TDAY_ICG_CNCL_SBSCR_CASCNT("TDAY_ICG_CNCL_SBSCR_CASCNT")
			
			, ORG_NM("ORG_NM")
			, OCC_SUM_PRVD_CASCNT("OCC_SUM_PRVD_CASCNT")
			
			, FEE_ACRU_YM("FEE_ACRU_YM")
			, SETL_YM("SETL_YM")
			, TGT_ORG_ID("TGT_ORG_ID")
			, FEE_CD("FEE_CD")
			, ORIGIN_SETL_ACC_ID("ORIGIN_SETL_ACC_ID")
			, PROD_SVC_ID("PROD_SVC_ID")
			, PROD_NM("PROD_NM")
			, FEE_BASIS_CASCNT("FEE_BASIS_CASCNT")
			, TOTALCNT("TOTALCNT")
			, FEE_BASIS_AMT("FEE_BASIS_AMT")
			, TOTALAMOUNT("TOTALAMOUNT")
			
			, SVC_CONT_NO("SVC_CONT_NO")
			, FEE_DCID_AMT("FEE_DCID_AMT")
			
			, ACCUM_YM("ACCUM_YM")
			, SETL_ACC_ID("SETL_ACC_ID")
			, ACCUM_GUIDE_DATA_VAL("ACCUM_GUIDE_DATA_VAL")
			, ACCUM_GUIDE_DATA_AMT("ACCUM_GUIDE_DATA_AMT")
			
			, SETL_ID("SETL_ID")
			, FEE_STTUS_CD("FEE_STTUS_CD")
			, GUIDE_DATA_ID("GUIDE_DATA_ID")
			, PTNR_PLCY_ID("PTNR_PLCY_ID")
			, PLCY_UNIT_ID("PLCY_UNIT_ID")
			, SETL_ACCUM_ID("SETL_ACCUM_ID")
			, SETL_TYPE_ID("SETL_TYPE_ID")
			, FEE_TOT_AMT("FEE_TOT_AMT")
			, APD_FEE_TOT_AMT("APD_FEE_TOT_AMT")
			, LOW_ORG_ID("LOW_ORG_ID")

			, GUIDE_DATA_DTL_ID("GUIDE_DATA_DTL_ID")
			, FACTR_ID("FACTR_ID")
			, FACTR_NM("FACTR_NM")
			, FACTR_VAL("FACTR_VAL")
			, FACTR_VAL_SBST("FACTR_VAL_SBST")
			, EV_DT("EV_DT")
			, CHG_WHY_VAL("CHG_WHY_VAL")
			
			, TRC_ORG_ID("TRC_ORG_ID")
			, OCC_ORG_ID("OCC_ORG_ID")
			, APLY_FNS_YM("APLY_FNS_YM")
			, SETL_TRC_EXP_YM("SETL_TRC_EXP_YM")
			, APLY_ST_YM("APLY_ST_YM")
			, SETL_TRC_EFCT_YM("SETL_TRC_EFCT_YM")
			, TKO_ORG_ID("TKO_ORG_ID")
			
			, TRC_DIV_CD("TRC_DIV_CD")
			, TRC_CD("TRC_CD")
			
			, SBSD_PRVD_DT("TRC_CD")
			, SBSD_SUCC_AMT("TRC_CD")
			, HNDSET_INSL_AMT("TRC_CD")
			, USIM_INSL_AMT("TRC_CD")
			, BOND_SUCC_AMT("TRC_CD")
			
			;
			private String value;
			private ColumnName(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}	
		}
		public enum ColumnValue {
			  EmptyString("")
			, N("N")
			, I("I")
			;
			private String value;
			private ColumnValue(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum DataPush {
			  feeBySvcContNo("feeBySvcContNo")
			, fee("fee")
			, feeCd("feeCd")
			, mnsBas("mnsBas")
			, mnsDtl("mnsDtl")
			, feeByProd("feeByProd")
			, moveFeeOverOrgMonthly("moveFeeOverOrgMonthly")
			, dealerPerformance("dealerPerformance")
			, bizPerformanceAgency("bizPerformanceAgency")
			, moveFeeOverOrgDaily("moveFeeOverOrgDaily")
			, businessPerformanceAgency("businessPerformanceAgency")
			, businessPerformanceDaily("businessPerformanceDaily")
			, successionInfoDaily("successionInfoDaily")
			, proofResult("proofResult")
			, agencyPenaltyConfirm("agencyPenaltyConfirm")
			, accumAgency("accumAgency")
			, accumCpnt("accumCpnt")
			, accumModel("accumModel")
			;
			private String value;
			private DataPush(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum PushFile {
			  SEND_SKYLIFE("SEND_SKYLIFE")
			;
			private String value;
			private PushFile(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum DataSync {
			intmModel("intmModel")
			, intmModelPrice("intmModelPrice")
			, ktOrg("ktOrg")
			, addrInfo("addrInfo")
			, prodInfo("prodInfo")
			, prodDcInfo("prodDcInfo")
			, prodCouponInfo("prodCouponInfo")
			, userInfo("userInfo")
			
			;
			private String value;
			private DataSync(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum Event {
			formPaperVerification("formPaperVerification")
			, piaCardSlng("piaCardSlng")
			, chrCoupnSlng("chrCoupnSlng")
			, opnCpnt("opnCpnt")
			, custDscntSr("custDscntSr")
			, shandIntmHomdlv("shandIntmHomdlv")
			, agencyPenalty("agencyPenalty")
			, penaltyReceiveMoney("penaltyReceiveMoney")
			, srttFormVerification("srttFormVerification")
			, nonodrFormVerification("nonodrFormVerification")
			;
			private String value;
			private Event(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum EventFile {
			RECEIPT("RECEIPT")
			, BLTYPE("BLTYPE")
			, RMNY_VICEX("RMNY_VICEX")
			;
			private String value;
			private EventFile(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		public enum EventDw {
			agncyTlkCascnt("agncyTlkCascnt")
			, custTlkSum("custTlkSum")
			, resbsPtclAcru("resbsPtclAcru")
			;
			private String value;
			private EventDw(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
		
		public enum ExcelDown {
			GUIDE_DATA("GUIDE_DATA")
			, SETTLEMENT_DATA("SETTLEMENT_DATA")
			, GUIDE_FEE_SUM("GUIDE_FEE_SUM")
			, GUIDE_PLCY_SUM("GUIDE_PLCY_SUM")
			;

			private String value;
			private ExcelDown(String value) {
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public boolean isMatch(String compare) {
				return value.equals(compare);
			}
		}
	}
	public enum ErrorMessageParam {
		REQ("승인요청"),
		APPROVAL("승인"),
		CANCEL("취소"),
		REJECT("반려"),
		POLICY_MODIFICATION("정책수정"),
		POLICY_DISCARD("정책폐기"),
		POLICY_APPROVAL_REQUEST("정책승인요청"),
		EARLY_TERMINATION_DATE_MODIFICATION("조기종료일시수정")
		;
		private String value;
		private ErrorMessageParam(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	public enum Auth {
		TOP_ORG_ID("361001"), // Customer부문
		SEARCH_INDIVIDUAL_ORG_AUTH("P-40024"), // 지급점 권한
		IT_SERVICE_MANANGEMENT_GENERAL("C-10037"), // IT 운영조직 일반 권한
		LOOKUP_ANY_ORG_OF_GUIDING("P-40016") // 실적 전사 조회 권한 
		;
		private String value;
		private Auth(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	public enum ScreenViewId {
		FEE_PYMN_LIST_2("feePymnList2") // 조직별수수료실적조회 화면
		;
		private String value;
		private ScreenViewId(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	public enum MsgDspCycle {
		MONTHLY("MONTHLY"),DAILY("DAILY"), HOURLY("HOURLY"), WEEKLY("WEEKLY");
		private String value;
		private MsgDspCycle(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
}