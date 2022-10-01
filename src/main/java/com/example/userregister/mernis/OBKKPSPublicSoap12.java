package com.example.userregister.mernis;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 6.0.1.1
//
// Created by Quasar Development 
//
//----------------------------------------------------



import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;
import org.kxml2.kdom.Element;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OBKKPSPublicSoap12
{
    interface OBKIWcfMethod
    {
        OBKExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws java.lang.Exception;

        java.lang.Object ProcessResult(OBKExtendedSoapSerializationEnvelope __envelope,java.lang.Object result) throws java.lang.Exception;
    }

    String url="https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";

    int timeOut=60000;
    
    public List< HeaderProperty> httpHeaders= new ArrayList< HeaderProperty>();
    public boolean enableLogging;


    public OBKKPSPublicSoap12(){}

    public OBKKPSPublicSoap12(String url)
    {
        this.url = url;
    }

    public OBKKPSPublicSoap12(String url,int timeOut)
    {
        this.url = url;
        this.timeOut=timeOut;
    }

    protected org.ksoap2.transport.Transport createTransport()
    {
        try
        {
            java.net.URI uri = new java.net.URI(url);
            if(uri.getScheme().equalsIgnoreCase("https"))
            {
                int port=uri.getPort()>0?uri.getPort():443;
                String path=uri.getPath();
                if(uri.getQuery()!=null && uri.getQuery()!="")
                {
                    path+="?"+uri.getQuery();
                }
                return new com.easywsdl.exksoap2.transport.AdvancedHttpsTransportSE(uri.getHost(), port, path, timeOut);
            }
            else
            {
                return new com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE(url,timeOut);
            }

        }
        catch (java.net.URISyntaxException e)
        {
        }
        return null;
    }

    protected OBKExtendedSoapSerializationEnvelope createEnvelope()
    {
        OBKExtendedSoapSerializationEnvelope envelope= new OBKExtendedSoapSerializationEnvelope(OBKExtendedSoapSerializationEnvelope.VER12);
        envelope.enableLogging = enableLogging;
    
        return envelope;
    }

    protected java.util.List sendRequest(String methodName,OBKExtendedSoapSerializationEnvelope envelope,org.ksoap2.transport.Transport transport ,com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile profile )throws java.lang.Exception
    {
        if(transport instanceof com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE )
        {
            return ((com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE)transport).call(methodName, envelope,httpHeaders,null,profile);
        }
        else
        {
            return ((com.easywsdl.exksoap2.transport.AdvancedHttpsTransportSE)transport).call(methodName, envelope,httpHeaders,null,profile);
        }
    }

    java.lang.Object getResult(java.lang.Class destObj,java.lang.Object source,String resultName,OBKExtendedSoapSerializationEnvelope __envelope) throws java.lang.Exception
    {
        if(source==null)
        {
            return null;
        }
        if(source instanceof SoapPrimitive)
        {
            SoapPrimitive soap =(SoapPrimitive)source;
            if(soap.getName().equals(resultName))
            {
                java.lang.Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
        }
        else
        {
            SoapObject soap = (SoapObject)source;
            if (soap.hasProperty(resultName))
            {
                java.lang.Object j=soap.getProperty(resultName);
                if(j==null)
                {
                    return null;
                }
                java.lang.Object instance=__envelope.get(j,destObj,false);
                return instance;
            }
            else if( soap.getName().equals(resultName)) 
            {
                java.lang.Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
        }

        return null;
    }

    
    
    
    public Boolean TCKimlikNoDogrula(final Long TCKimlikNo,final String Ad,final String Soyad,final Integer DogumYili) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (Boolean)execute(new OBKIWcfMethod()
        {
            @Override
            public OBKExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                OBKExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://tckimlik.nvi.gov.tr/WS", "TCKimlikNoDogrula");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="http://tckimlik.nvi.gov.tr/WS";
                __info.name="TCKimlikNo";
                __info.type=PropertyInfo.LONG_CLASS;
                __info.setValue(TCKimlikNo);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="http://tckimlik.nvi.gov.tr/WS";
                __info.name="Ad";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(Ad!=null?Ad:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="http://tckimlik.nvi.gov.tr/WS";
                __info.name="Soyad";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(Soyad!=null?Soyad:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="http://tckimlik.nvi.gov.tr/WS";
                __info.name="DogumYili";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(DogumYili);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(OBKExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                SoapObject __soap=(SoapObject)__result;
                java.lang.Object obj = __soap.getProperty("TCKimlikNoDogrulaResult");        
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return Boolean.valueOf(j.toString());
                }
                else if (obj!= null && obj instanceof Boolean){
                    return (Boolean)obj;
                }
                return null;
            }
        },"http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula",__profile);
    }

    protected java.lang.Object execute(OBKIWcfMethod wcfMethod,String methodName,com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile profile) throws java.lang.Exception
    {
        org.ksoap2.transport.Transport __httpTransport=createTransport();
        __httpTransport.debug=enableLogging;
        OBKExtendedSoapSerializationEnvelope __envelope=wcfMethod.CreateSoapEnvelope();
        try
        {
            sendRequest(methodName, __envelope, __httpTransport,profile);
        }
        finally {
            if (__httpTransport.debug) {
                if (__httpTransport.requestDump != null) {
                    System.out.println("requestDump: "+__httpTransport.requestDump);

                }
                if (__httpTransport.responseDump != null) {
                    System.out.println("responseDump: "+__httpTransport.responseDump);
                }
            }
        }
        java.lang.Object __retObj = __envelope.bodyIn;
        if (__retObj instanceof org.ksoap2.SoapFault){
            org.ksoap2.SoapFault __fault = (org.ksoap2.SoapFault)__retObj;
            throw convertToException(__fault,__envelope);
        }else{
            return wcfMethod.ProcessResult(__envelope,__retObj);
        }
    }


    protected java.lang.Exception convertToException(org.ksoap2.SoapFault fault,OBKExtendedSoapSerializationEnvelope envelope)
    {
        org.ksoap2.SoapFault newException = fault;
        return newException;
    }
}


