package com.apkupdater.transform

import android.content.Context
import android.content.pm.PackageInfo
import android.net.Uri
import android.os.Build
import com.apkupdater.data.AppInstalled
import com.apkupdater.util.name


@Suppress("DEPRECATION")
fun PackageInfo.toAppInstalled(context: Context, ignored: List<String>) = AppInstalled(
	name(context),
	packageName,
	versionName.orEmpty(),
	if (Build.VERSION.SDK_INT >= 28) longVersionCode else versionCode.toLong(),
	iconUri(packageName, applicationInfo.icon),
	ignored.contains(packageName)
)

fun iconUri(packageName: String, id: Int): Uri = Uri.parse("android.resource://$packageName/$id")

