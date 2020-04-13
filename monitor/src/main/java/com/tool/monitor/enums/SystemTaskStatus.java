package com.tool.monitor.enums;

public enum SystemTaskStatus {
    未发布("未发布", 1),
    已发布("已发布", 2),
    已接受("已接受", 3),
    完成("完成", 4),
    验收通过("验收通过", 5),
    暂停("暂停", 6),
    取消("取消", 7),
    已发布暂停("已发布-暂停", 8),
    已接受暂停("已接受-暂停", 9),
    完成暂停("完成暂停", 10),
    需求接收与设计阶段("需求接收与设计阶段", 11),
    开发中("开发中", 12),
    开发完成("开发完成", 13),
    发版完成LT("发版完成", 14),
    测试完成LT("测试完成", 15),
    发版中("发版中", 16),
    发版完成("发版完成", 17),
    测试中("测试中", 18),
    测试完成("测试完成", 19),
    投产完成("投产完成", 20),
    作废("作废", 21);


    private final String typeName;
    private final int typeVal;

    SystemTaskStatus(String typeName, int typeVal) {
        this.typeName = typeName;
        this.typeVal = typeVal;
    }

    public static String getEnumType(int val) {
        for (SystemTaskStatus type : SystemTaskStatus.values()) {
            if (type.getTypeVal() == val) {
                return type.getTypeName();
            }
        }
        return null;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getTypeVal() {
        return typeVal;
    }
}
