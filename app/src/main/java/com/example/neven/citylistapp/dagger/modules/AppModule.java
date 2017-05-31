package com.example.neven.citylistapp.dagger.modules;

import com.example.neven.citylistapp.utils.TLSSocketFactory;
import dagger.Module;
import dagger.Provides;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

/**
 * Created by Neven on 30.5.2017..
 */
@Module
public class AppModule {

    TLSSocketFactory tlsSocketFactory;


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {

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


        return client;
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://edina.info.tm/android/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }


}
