package com.tpe;

//web.xml yerine bu classi kullanacagiz.
//dispatcher servletin tanimlanmasi, configurationu ile basliyoruz.
//AbstractAnnotationConfigDispatcherServletInitializer dispatcher servletin baslatilmasini, config ayarlarinin
// bulundugu dosyanin yerinin gosterilmesini saglar.

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
    Dispatcher: Servlet WebAppContext --> Controller, Handler Mapping, View Resolver
                Root WebAppContext --> services, repositories
     */

    @Override // DB'ye erisim icin gerekli config ayarlarini iceren bir class tanimlayacagiz.
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override // Controller, Handler Mapping, View Resolver ile ilgili config ayarlarini iceren bir class tanimlayacagiz.
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
          WebMvcConfig.class
        };
    }

    @Override // Hangi url ile gelen request(istek) ler servlet tarafindan karsilanacak ?
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
