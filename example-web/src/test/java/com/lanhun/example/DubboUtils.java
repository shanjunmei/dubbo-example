package com.lanhun.example;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.lanhun.example.api.model.ExampleModel;
import com.lanhun.example.api.service.ExampleApiService;

/**
 * Created by Administrator on 2016/12/23.
 */
public class DubboUtils {


    public static void main(String args[]) {
        String serverUrl = "dubbo://192.168.5.29:20982/com.lanhun.example.api.service.ExampleApiService";

        // service(serverUrl);

        //  generic(serverUrl);

        ExampleApiService purchaseOrderApiService = create(ExampleApiService.class, serverUrl, "1.0");
        ExampleModel order = purchaseOrderApiService.example("CGDD201701170020");

        System.out.println(order);
    }


    public static void generic(String serverUrl) {
        GenericService service = create(serverUrl, "1.0");
        System.out.println(service);
        Object t = service.$invoke("hasPriceScheme", new String[]{"java.lang.String"}, new Object[]{"GD2605748606600"});
        System.out.println(t);
    }

    public static GenericService create(String serverUrl, String version) {
        DubboProtocol protocol = DubboProtocol.getDubboProtocol();
        ProxyFactory proxy = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();

        if (version != null && version.trim().length() > 0) {
            serverUrl = serverUrl + "?version=" + version;
        }
        URL url = URL.valueOf(serverUrl);
        Invoker<GenericService> invoker = protocol.refer(GenericService.class, url);

        GenericService service = proxy.getProxy(invoker);
        return service;
    }

    public static <T> T create(Class<T> cls, String serverUrl, String version) {
        DubboProtocol protocol = DubboProtocol.getDubboProtocol();
        ProxyFactory proxy = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();
        if (version != null && version.trim().length() > 0) {
            serverUrl = serverUrl + "?version=" + version;
        }
        URL url = URL.valueOf(serverUrl);
        Invoker<T> invoker = protocol.refer(cls, url);
        T service = proxy.getProxy(invoker);
        return service;
    }
}