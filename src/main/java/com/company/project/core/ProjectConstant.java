package com.company.project.core;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.company.project";//生成代码所在的基础包名称，可根据自己公司的项目修改（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";//生成的Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//生成的Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//生成的Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//生成的ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";//生成的Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";//Mapper插件基础接口的完全限定名


    public static final long SDK_APP_ID=1400202398;
    public static final String ADMIN_IDENTIFIER="admin";
    public static final String ADMIN_USERSIG="eJxlz01Pg0AQgOE7v4Jw1dj96AI16YEgNqhVKrUxvRDSHdYp7XZDt4TG*N*NqJHEuT7vZDLvjuu63vIhvyo3m8NJ28KeDXjutesR7-IPjUFZlLbgjfyH0BlsoCgrC02PVAjBCBk2KEFbrPCnKOUe9YCPsi76G9-7Y0IYYXwSDhNUPc6TRZwm*XZk77JnETMZ1KVed*rJpoqvIrlOYpA48avH*3zXZi8RRuw03t283i59WREFqHS3zUbtLJUUjJlDNxM8rLJVffG2mE4HJy3u4fehgDM-pMFAW2iOeNB9wAgVlHHyNZ7z4XwCCvBc*g__";

    public static final String PRIVATE_KEY="-----BEGIN PRIVATE KEY-----\n" + "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgHCNFH5WIGH4m5Gtp\n" + "uYqyQWlU7/4ZSU6SpPLA0TpNkfWhRANCAAQrBTscWfWLcwFyTe6AKx2lBsir8q3/\n" + "SSnVeIxeU41Xen2MD6dxMK/bZc5GSVTF+UmSinM5JP9spMfXxX+bsri1\n" + "-----END PRIVATE KEY-----\n";
    public static final String PUBLIC_KEY="-----BEGIN PUBLIC KEY-----\n" + "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEKwU7HFn1i3MBck3ugCsdpQbIq/Kt\n" + "/0kp1XiMXlONV3p9jA+ncTCv22XORklUxflJkopzOST/bKTH18V/m7K4tQ==\n" + "-----END PUBLIC KEY-----\n";
}
