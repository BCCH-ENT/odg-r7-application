package com.bcch.neilconnatty.streamingplugin.screenshot;

import android.os.Bundle;

import com.quickblox.content.QBContent;
import com.quickblox.content.model.QBFile;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.core.request.QBPagedRequestBuilder;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by neilconnatty on 2016-11-07.
 */

public class PhotoUploader
{
    private static final String TAG = PhotoUploader.class.getSimpleName();

    private static ArrayList<QBFile> uploadedFiles = new ArrayList<>();

    public static void uploadNewFile (final File file, QBEntityCallback<QBFile> callback)
    {
        for (QBFile qbFile : uploadedFiles)
        {
            QBContent.deleteFile(qbFile.getId(), new QBEntityCallback<Void>() {
                @Override
                public void onSuccess(Void aVoid, Bundle bundle) {

                }

                @Override
                public void onError(QBResponseException e) {

                }
            });
        }
        uploadedFiles.clear();

        QBContent.uploadFileTask(file, true, "bcch", callback);
    }

    public static void registerNewFile (QBFile qbFile)
    {
        uploadedFiles.add(qbFile);
    }

    public static void deleteFiles ()
    {
        for (QBFile qbFile : uploadedFiles)
        {
            QBContent.deleteFile(qbFile.getId(), new QBEntityCallback<Void>() {
                @Override
                public void onSuccess(Void aVoid, Bundle bundle) {

                }

                @Override
                public void onError(QBResponseException e) {

                }
            });
        }
    }

    public static void updateFile (final File file, QBEntityCallback<QBFile> callback)
    {
        QBContent.updateFileTask(file, 6316512, "bcch", callback);
    }
}
