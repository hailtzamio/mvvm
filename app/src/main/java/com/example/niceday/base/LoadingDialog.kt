package com.example.niceday.base

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.example.niceday.R

class LoadingDialog {


    companion object {

        var progressDialogBuilder: AlertDialog.Builder? = null
        var progressDialog: AlertDialog? = null
        fun showProgressDialog(
            context: Context?, titleID: Int,
            messageID: Int
        ) {
            if (context is Activity) {
                if (context.isFinishing) {
                    return
                }
            }
            if (context == null) return
            try {
                progressDialogBuilder = AlertDialog.Builder(context)

                if (progressDialog != null) {
                    if (!progressDialog!!.isShowing) {
                        progressDialog!!.show()
                    }
                } else {
                    progressDialog = progressDialogBuilder!!.create()
                    progressDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    progressDialog!!.show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                progressDialog = null
                showProgressDialog(context, titleID, messageID)
                return
            }
            progressDialog!!.setContentView(R.layout.progress_dialog)
            progressDialog!!.setCancelable(false)
        }

        fun dismissProgressDialog() {
            try {
                if (progressDialog != null && progressDialog!!.isShowing) {
                    progressDialog!!.dismiss()
                    progressDialog = null
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}