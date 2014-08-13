package com.mao.servicemanagerlib.service.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import android.content.res.AssetManager;

import com.mao.servicemanagerlib.service.core.Cache;
import com.mao.servicemanagerlib.service.domain.SdkRequest;

public class ConfigUtils {
	// ERROR //
	private Map<String, SdkRequest> getApiMetaData(String paramString) {
		return null;
		// Byte code:
		// 0: new 19 java/util/HashMap
		// 3: dup
		// 4: invokespecial 20 java/util/HashMap:<init> ()V
		// 7: astore_2
		// 8: invokestatic 26
		// javax/xml/parsers/DocumentBuilderFactory:newInstance
		// ()Ljavax/xml/parsers/DocumentBuilderFactory;
		// 11: invokevirtual 30
		// javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder
		// ()Ljavax/xml/parsers/DocumentBuilder;
		// 14: getstatic 36 com/tbc/paas/sdk/util/SdkContext:context
		// Landroid/content/Context;
		// 17: invokevirtual 42 android/content/Context:getResources
		// ()Landroid/content/res/Resources;
		// 20: invokevirtual 48 android/content/res/Resources:getAssets
		// ()Landroid/content/res/AssetManager;
		// 23: aload_1
		// 24: invokevirtual 54 android/content/res/AssetManager:open
		// (Ljava/lang/String;)Ljava/io/InputStream;
		// 27: invokevirtual 60 javax/xml/parsers/DocumentBuilder:parse
		// (Ljava/io/InputStream;)Lorg/w3c/dom/Document;
		// 30: invokeinterface 66 1 0
		// 35: ldc 68
		// 37: invokeinterface 74 2 0
		// 42: astore 7
		// 44: iconst_0
		// 45: istore 8
		// 47: aload 7
		// 49: invokeinterface 80 1 0
		// 54: istore 9
		// 56: iload 8
		// 58: iload 9
		// 60: if_icmplt +13 -> 73
		// 63: iconst_0
		// 64: ifeq +7 -> 71
		// 67: aconst_null
		// 68: invokevirtual 85 java/io/BufferedReader:close ()V
		// 71: aload_2
		// 72: areturn
		// 73: aload 7
		// 75: iload 8
		// 77: invokeinterface 89 2 0
		// 82: checkcast 70 org/w3c/dom/Element
		// 85: astore 10
		// 87: aload 10
		// 89: invokeinterface 93 1 0
		// 94: ldc 95
		// 96: invokeinterface 101 2 0
		// 101: invokeinterface 107 1 0
		// 106: astore 11
		// 108: aload 10
		// 110: invokeinterface 93 1 0
		// 115: ldc 109
		// 117: invokeinterface 101 2 0
		// 122: invokeinterface 107 1 0
		// 127: astore 12
		// 129: aload 10
		// 131: invokeinterface 93 1 0
		// 136: ldc 111
		// 138: invokeinterface 101 2 0
		// 143: invokeinterface 107 1 0
		// 148: astore 13
		// 150: new 113 com/tbc/paas/sdk/domain/SdkRequest
		// 153: dup
		// 154: invokespecial 114 com/tbc/paas/sdk/domain/SdkRequest:<init> ()V
		// 157: astore 14
		// 159: aload 14
		// 161: aload 12
		// 163: invokevirtual 118
		// com/tbc/paas/sdk/domain/SdkRequest:setServiceName
		// (Ljava/lang/String;)V
		// 166: aload 14
		// 168: aload 11
		// 170: invokevirtual 121
		// com/tbc/paas/sdk/domain/SdkRequest:setMethodName
		// (Ljava/lang/String;)V
		// 173: aload 14
		// 175: aload 13
		// 177: invokevirtual 124 com/tbc/paas/sdk/domain/SdkRequest:setUri
		// (Ljava/lang/String;)V
		// 180: new 19 java/util/HashMap
		// 183: dup
		// 184: invokespecial 20 java/util/HashMap:<init> ()V
		// 187: astore 15
		// 189: aload 10
		// 191: ldc 126
		// 193: invokeinterface 74 2 0
		// 198: astore 16
		// 200: iconst_0
		// 201: istore 17
		// 203: iload 17
		// 205: aload 16
		// 207: invokeinterface 80 1 0
		// 212: if_icmplt +50 -> 262
		// 215: aload 14
		// 217: aload 15
		// 219: invokevirtual 130
		// com/tbc/paas/sdk/domain/SdkRequest:setParamKeys (Ljava/util/Map;)V
		// 222: aload_2
		// 223: new 132 java/lang/StringBuilder
		// 226: dup
		// 227: aload 12
		// 229: invokestatic 138 java/lang/String:valueOf
		// (Ljava/lang/Object;)Ljava/lang/String;
		// 232: invokespecial 140 java/lang/StringBuilder:<init>
		// (Ljava/lang/String;)V
		// 235: ldc 142
		// 237: invokevirtual 146 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 240: aload 11
		// 242: invokevirtual 146 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 245: invokevirtual 149 java/lang/StringBuilder:toString
		// ()Ljava/lang/String;
		// 248: aload 14
		// 250: invokeinterface 155 3 0
		// 255: pop
		// 256: iinc 8 1
		// 259: goto -212 -> 47
		// 262: aload 16
		// 264: iload 17
		// 266: invokeinterface 89 2 0
		// 271: checkcast 70 org/w3c/dom/Element
		// 274: astore 18
		// 276: aload 15
		// 278: aload 18
		// 280: invokeinterface 93 1 0
		// 285: ldc 157
		// 287: invokeinterface 101 2 0
		// 292: invokeinterface 107 1 0
		// 297: invokestatic 163 java/lang/Integer:parseInt
		// (Ljava/lang/String;)I
		// 300: invokestatic 166 java/lang/Integer:valueOf
		// (I)Ljava/lang/Integer;
		// 303: aload 18
		// 305: invokeinterface 93 1 0
		// 310: ldc 95
		// 312: invokeinterface 101 2 0
		// 317: invokeinterface 107 1 0
		// 322: invokeinterface 155 3 0
		// 327: pop
		// 328: iinc 17 1
		// 331: goto -128 -> 203
		// 334: astore 5
		// 336: new 168 com/tbc/paas/sdk/domain/SdkException
		// 339: dup
		// 340: aload 5
		// 342: ldc 170
		// 344: iconst_1
		// 345: anewarray 134 java/lang/String
		// 348: dup
		// 349: iconst_0
		// 350: aload_1
		// 351: aastore
		// 352: invokespecial 173 com/tbc/paas/sdk/domain/SdkException:<init>
		// (Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/String;)V
		// 355: astore 6
		// 357: aload 6
		// 359: athrow
		// 360: astore_3
		// 361: iconst_0
		// 362: ifeq +7 -> 369
		// 365: aconst_null
		// 366: invokevirtual 85 java/io/BufferedReader:close ()V
		// 369: aload_3
		// 370: athrow
		// 371: astore 4
		// 373: goto -4 -> 369
		// 376: astore 21
		// 378: aload_2
		// 379: areturn
		//
		// Exception table:
		// from to target type
		// 8 44 334 java/lang/Exception
		// 47 56 334 java/lang/Exception
		// 73 200 334 java/lang/Exception
		// 203 256 334 java/lang/Exception
		// 262 328 334 java/lang/Exception
		// 8 44 360 finally
		// 47 56 360 finally
		// 73 200 360 finally
		// 203 256 360 finally
		// 262 328 360 finally
		// 336 360 360 finally
		// 365 369 371 java/io/IOException
		// 67 71 376 java/io/IOException
	}

	private String[] getApiMetadataFiles() {
		AssetManager localAssetManager = SdkContext.context.getResources()
				.getAssets();
		try {
			String[] arrayOfString = localAssetManager
					.list(SdkContext.configApiInAssetsFilePath);
			return arrayOfString;
		} catch (IOException localIOException) {
		}
		throw new IllegalArgumentException(
				"Can't read apiMetadataFile from path("
						+ SdkContext.configApiInAssetsFilePath + ")");
	}

	// ERROR //
	private Properties getSourcePathProperties(String paramString) {
		return null;
		// Byte code:
		// 0: aconst_null
		// 1: astore_2
		// 2: getstatic 36 com/tbc/paas/sdk/util/SdkContext:context
		// Landroid/content/Context;
		// 5: astore 6
		// 7: aconst_null
		// 8: astore_2
		// 9: aload 6
		// 11: ifnonnull +69 -> 80
		// 14: iconst_2
		// 15: anewarray 134 java/lang/String
		// 18: astore 7
		// 20: aload 7
		// 22: iconst_0
		// 23: ldc 32
		// 25: invokevirtual 197 java/lang/Class:getName ()Ljava/lang/String;
		// 28: aastore
		// 29: aload 7
		// 31: iconst_1
		// 32: ldc 198
		// 34: aastore
		// 35: new 168 com/tbc/paas/sdk/domain/SdkException
		// 38: dup
		// 39: ldc 200
		// 41: aload 7
		// 43: invokespecial 203 com/tbc/paas/sdk/domain/SdkException:<init>
		// (Ljava/lang/String;[Ljava/lang/String;)V
		// 46: athrow
		// 47: astore 5
		// 49: new 168 com/tbc/paas/sdk/domain/SdkException
		// 52: dup
		// 53: aload 5
		// 55: ldc 170
		// 57: iconst_1
		// 58: anewarray 134 java/lang/String
		// 61: dup
		// 62: iconst_0
		// 63: aload_1
		// 64: aastore
		// 65: invokespecial 173 com/tbc/paas/sdk/domain/SdkException:<init>
		// (Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/String;)V
		// 68: athrow
		// 69: astore_3
		// 70: aload_2
		// 71: ifnull +7 -> 78
		// 74: aload_2
		// 75: invokevirtual 206 java/io/InputStream:close ()V
		// 78: aload_3
		// 79: athrow
		// 80: getstatic 36 com/tbc/paas/sdk/util/SdkContext:context
		// Landroid/content/Context;
		// 83: invokevirtual 42 android/content/Context:getResources
		// ()Landroid/content/res/Resources;
		// 86: invokevirtual 48 android/content/res/Resources:getAssets
		// ()Landroid/content/res/AssetManager;
		// 89: aload_1
		// 90: invokevirtual 54 android/content/res/AssetManager:open
		// (Ljava/lang/String;)Ljava/io/InputStream;
		// 93: astore_2
		// 94: aload_2
		// 95: ifnull +29 -> 124
		// 98: new 208 java/util/Properties
		// 101: dup
		// 102: invokespecial 209 java/util/Properties:<init> ()V
		// 105: astore 8
		// 107: aload 8
		// 109: aload_2
		// 110: invokevirtual 213 java/util/Properties:load
		// (Ljava/io/InputStream;)V
		// 113: aload_2
		// 114: ifnull +7 -> 121
		// 117: aload_2
		// 118: invokevirtual 206 java/io/InputStream:close ()V
		// 121: aload 8
		// 123: areturn
		// 124: new 168 com/tbc/paas/sdk/domain/SdkException
		// 127: dup
		// 128: ldc 170
		// 130: iconst_1
		// 131: anewarray 134 java/lang/String
		// 134: dup
		// 135: iconst_0
		// 136: aload_1
		// 137: aastore
		// 138: invokespecial 203 com/tbc/paas/sdk/domain/SdkException:<init>
		// (Ljava/lang/String;[Ljava/lang/String;)V
		// 141: athrow
		// 142: astore 4
		// 144: goto -66 -> 78
		// 147: astore 9
		// 149: aload 8
		// 151: areturn
		// 152: astore_3
		// 153: goto -83 -> 70
		// 156: astore 5
		// 158: goto -109 -> 49
		//
		// Exception table:
		// from to target type
		// 2 7 47 java/io/IOException
		// 14 47 47 java/io/IOException

		// 80 94 47 java/io/IOException
		// 98 107 47 java/io/IOException
		// 124 142 47 java/io/IOException
		// 2 7 69 finally
		// 14 47 69 finally
		// 49 69 69 finally
		// 80 94 69 finally
		// 98 107 69 finally
		// 124 142 69 finally
		// 74 78 142 java/io/IOException
		// 117 121 147 java/io/IOException
		// 107 113 152 finally
		// 107 113 156 java/io/IOException
	}

	public void initConfig() {
		Properties localProperties = getSourcePathProperties(SdkContext.configAppInAssetsFilePath);
		if (localProperties != null) {
			if (StringUtils.isEmpty(SdkContext.openServerAppKey))
				SdkContext.openServerAppKey = localProperties
						.getProperty("open.account.appKey");
			if (StringUtils.isEmpty(SdkContext.openServerAppSecret))
				SdkContext.openServerAppSecret = localProperties
						.getProperty("open.account.appSecret");
			if (StringUtils.isEmpty(SdkContext.openServerName))
				SdkContext.openServerName = localProperties
						.getProperty("open.server.name");
			if (StringUtils.isEmpty(SdkContext.openServerUrl))
				SdkContext.openServerUrl = "http://"
						+ SdkContext.openServerName + "/open";
			if (StringUtils.isEmpty(SdkContext.openServerVersion))
				SdkContext.openServerVersion = localProperties
						.getProperty("open.server.version");
			if (SdkContext.connectionTimeout == 0) {
				String str = localProperties.getProperty("open.server.timeout");
				if (str == null)
					SdkContext.connectionTimeout = 10000;
				SdkContext.connectionTimeout = Integer.parseInt(str);
			}
		}
		while (true) {
			if (StringUtils.isEmpty(SdkContext.encod)) {
				if (!StringUtils.isEmpty(localProperties
						.getProperty("open.server.encode")))
					break;
				SdkContext.encod = "UTF-8";
			}
			return;
		}
		SdkContext.encod = localProperties.getProperty("open.server.encode");
	}

	// ERROR //
	public void initErrorMsg() {
		// Byte code:
		// 0: aconst_null
		// 1: astore_1
		// 2: getstatic 273
		// com/tbc/paas/sdk/util/SdkContext:configErrorMsgInAssetsFilePath
		// Ljava/lang/String;
		// 5: astore_2
		// 6: getstatic 36 com/tbc/paas/sdk/util/SdkContext:context
		// Landroid/content/Context;
		// 9: invokevirtual 42 android/content/Context:getResources
		// ()Landroid/content/res/Resources;
		// 12: invokevirtual 48 android/content/res/Resources:getAssets
		// ()Landroid/content/res/AssetManager;
		// 15: aload_2
		// 16: invokevirtual 54 android/content/res/AssetManager:open
		// (Ljava/lang/String;)Ljava/io/InputStream;
		// 19: astore_1
		// 20: aload_1
		// 21: ifnull +32 -> 53
		// 24: new 208 java/util/Properties
		// 27: dup
		// 28: invokespecial 209 java/util/Properties:<init> ()V
		// 31: astore 6
		// 33: aload 6
		// 35: aload_1
		// 36: invokevirtual 213 java/util/Properties:load
		// (Ljava/io/InputStream;)V
		// 39: aload_1
		// 40: ifnull +7 -> 47
		// 43: aload_1
		// 44: invokevirtual 206 java/io/InputStream:close ()V
		// 47: aload 6
		// 49: putstatic 279 com/tbc/paas/sdk/core/Cache:errorMsgCache
		// Ljava/util/Map;
		// 52: return
		// 53: new 168 com/tbc/paas/sdk/domain/SdkException
		// 56: dup
		// 57: ldc 170
		// 59: iconst_1
		// 60: anewarray 134 java/lang/String
		// 63: dup
		// 64: iconst_0
		// 65: aload_2
		// 66: aastore
		// 67: invokespecial 203 com/tbc/paas/sdk/domain/SdkException:<init>
		// (Ljava/lang/String;[Ljava/lang/String;)V
		// 70: athrow
		// 71: astore 5
		// 73: new 168 com/tbc/paas/sdk/domain/SdkException
		// 76: dup
		// 77: aload 5
		// 79: ldc 170
		// 81: iconst_1
		// 82: anewarray 134 java/lang/String
		// 85: dup
		// 86: iconst_0
		// 87: aload_2
		// 88: aastore
		// 89: invokespecial 173 com/tbc/paas/sdk/domain/SdkException:<init>
		// (Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/String;)V
		// 92: athrow
		// 93: astore_3
		// 94: aload_1
		// 95: ifnull +7 -> 102
		// 98: aload_1
		// 99: invokevirtual 206 java/io/InputStream:close ()V
		// 102: aload_3
		// 103: athrow
		// 104: astore 4
		// 106: goto -4 -> 102
		// 109: astore 7
		// 111: goto -64 -> 47
		// 114: astore_3
		// 115: goto -21 -> 94
		// 118: astore 5
		// 120: goto -47 -> 73
		//
		// Exception table:
		// from to target type
		// 6 20 71 java/io/IOException
		// 24 33 71 java/io/IOException
		// 53 71 71 java/io/IOException
		// 6 20 93 finally
		// 24 33 93 finally
		// 53 71 93 finally
		// 73 93 93 finally
		// 98 102 104 java/io/IOException
		// 43 47 109 java/io/IOException
		// 33 39 114 finally
		// 33 39 118 java/io/IOException
	}

	public void initOpenApiMetadata() {
		HashMap<String, SdkRequest> localHashMap = new HashMap<String, SdkRequest>();
		String[] arrayOfString = getApiMetadataFiles();
		for (int i = 0;; i++) {
			if (i >= arrayOfString.length) {
				Cache.sdkRequestCache = localHashMap;
				return;
			}
			localHashMap
					.putAll(getApiMetaData(SdkContext.configApiInAssetsFilePath
							+ File.separator + arrayOfString[i]));
		}
	}
}