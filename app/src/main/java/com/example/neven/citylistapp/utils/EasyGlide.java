package com.example.neven.citylistapp.utils;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

import java.io.InputStream;

/**
 * Created by Neven on 31.5.2017..
 */
public class EasyGlide implements GlideModule {

    TLSSocketFactory tlsSocketFactory;


    @Override
    public void applyOptions(Context context, GlideBuilder builder) {


    }

    @Override
    public void registerComponents(Context context, Glide glide) {

        CertificatePinner certificatePinner = new CertificatePinner.Builder()
                .add("edina.info.tm", "sha256/47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU=")
                .add("edina.info.tm", "sha256/kpk9MzQ7HmXL38ZBwvsGoCePtKDxZtbT4hzTsJG+e/E=")
                .add("edina.info.tm", "sha256/YLh1dUR9y6Kja30RrAn7JKnbQG/uEtLMkBgFF2Fuihg=")
                .add("edina.info.tm", "sha256/Vjs8r4z+80wjNcr1YKepWQboSIRi63WsWXhIMN+eWys=")
                .build();

        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();


        try {
            tlsSocketFactory = new TLSSocketFactory();
            httpBuilder.sslSocketFactory(tlsSocketFactory, tlsSocketFactory.systemDefaultTrustManager());
        } catch (Exception e) {
            e.printStackTrace();
        }

        final OkHttpClient client = httpBuilder.certificatePinner(certificatePinner)
                .build();

        OkHttpUrlLoader.Factory factory = new OkHttpUrlLoader.Factory(client);
        glide.register(GlideUrl.class, InputStream.class, factory);


    }
}
