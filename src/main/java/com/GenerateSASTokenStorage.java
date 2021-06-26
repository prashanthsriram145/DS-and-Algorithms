package com;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.blob.sas.BlobContainerSasPermission;
import com.azure.storage.blob.sas.BlobServiceSasSignatureValues;
import com.azure.storage.common.sas.SasProtocol;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPermissions;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.SharedAccessBlobPermissions;
import com.microsoft.azure.storage.blob.SharedAccessBlobPolicy;
import lombok.extern.slf4j.Slf4j;
import org.apache.nifi.processors.azure.storage.utils.AzureStorageUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@Slf4j
public class GenerateSASTokenStorage {
    public static void GetFileSAS() {
        String accountName = "snowflakejdp";
        String key = "4X5EhXSiy5yZBxRWu+lW2KBm0qNs1+HZ0kt4kEQu2D9d75srn7fi3bBk8jIgrwUgHDDeLyC5QquFGtBvZFNREw==";
        String azureApiVersion = "2019-12-12";
        String blobEndpointUrl = String.format("https://%s.blob.core.windows.net/t30f011232daea2f9", accountName);
        try {
        Calendar calendar = Calendar.getInstance();
        String start = ZonedDateTime.now(ZoneOffset.UTC).withNano(0).toString();
        calendar.add(Calendar.DATE, 30);
        String expiry = ZonedDateTime.now(ZoneOffset.UTC).plusDays(30).withNano(0).toString();
        String stringToSign = URLEncoder.encode("blob/" + accountName + "t30f011232daea2f9", "UTF-8") + "\n" +
                "rdwl\n" +
                "b\n" +
                "sco\n" +
                start + "\n" +
                expiry + "\n" +
                "\n" +
                "https\n" +
                azureApiVersion + "\n";
        String signature = getHMAC256(key, stringToSign);
        String sasToken = null;

            sasToken = "sv=" + azureApiVersion +
                    "&ss=b" +
                    "&srt=sco" +
                    "&sp=rdwl" +
                    "&se=" + expiry +
                    "&st=" + start +
                    "&spr=https" +
                    "&sig=" + URLEncoder.encode(signature, "UTF-8");


            String sasTokenUri = String.format("%s?%s", blobEndpointUrl , sasToken);
            System.out.println(blobEndpointUrl + "?" + sasToken);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    private static String getHMAC256(String accountKey, String signStr) {
        String signature = null;
        try {
            SecretKeySpec secretKey = new SecretKeySpec(Base64.getDecoder().decode(accountKey), "HmacSHA256");
            Mac sha256HMAC = Mac.getInstance("HmacSHA256");
            sha256HMAC.init(secretKey);
            signature = Base64.getEncoder().encodeToString(sha256HMAC.doFinal(signStr.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signature;
    }
    public static void main(String[] args) throws InvalidKeyException, URISyntaxException, StorageException, URISyntaxException, StorageException, InvalidKeyException {
        //Account creds = new Account();
        String accountName = "snowflakejdp";
        String accountKey = "4X5EhXSiy5yZBxRWu+lW2KBm0qNs1+HZ0kt4kEQu2D9d75srn7fi3bBk8jIgrwUgHDDeLyC5QquFGtBvZFNREw==";
        String blobConnString = String.format(AzureStorageUtils.FORMAT_BLOB_CONNECTION_STRING, accountName, accountKey);
        BlobContainerSasPermission blobContainerSasPermission = new BlobContainerSasPermission()
                .setReadPermission(true)
                .setWritePermission(true)
                .setListPermission(true);
        BlobServiceSasSignatureValues builder = new BlobServiceSasSignatureValues(OffsetDateTime.now().plusDays(1), blobContainerSasPermission)
                .setProtocol(SasProtocol.HTTPS_ONLY);
        BlobClient client = new BlobClientBuilder()
                .connectionString(blobConnString).containerName("t30f011232daea2f9").blobName("")
                .buildClient();
        String blobContainerName = "t30f011232daea2f9";
        System.out.println((String.format("https://%s.blob.core.windows.net/%s?%s",client.getAccountName(), blobContainerName, client.generateSas(builder))));
    }
}
