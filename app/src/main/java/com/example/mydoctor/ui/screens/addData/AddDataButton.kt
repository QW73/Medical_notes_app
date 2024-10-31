package com.example.mydoctor.ui.screens.addData

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.R
import com.example.mydoctor.ui.screens.AddDataViewModel
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddDataButton(modifier: Modifier = Modifier, viewModel: AddDataViewModel) {

    val isButtonEnabled = viewModel.isSaveButtonEnabled
    val buttonColor =
        if (isButtonEnabled) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)

    Column {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(buttonColor, shape = RoundedCornerShape(24.dp))
                .clickable(enabled = isButtonEnabled) {
                    viewModel.saveData()
                }
                .padding(vertical = figmaHeightToDp(10f).dp), contentAlignment = Alignment.Center

        ) {
            Text(
                text = stringResource(R.string.note_save),
                fontSize = figmaFontSizeToSp(18f),
                lineHeight = figmaHeightToDp(24f).sp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
            )
        }
        Spacer(modifier = Modifier.height(figmaHeightToDp(24f).dp))

        //Временно
       /* Box(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(24.dp)
                )
                .clickable {
                    viewModel.deleteData()
                }
                .padding(vertical = figmaHeightToDp(10f).dp), contentAlignment = Alignment.Center

        ) {
            Text(
                text = "ssas",
                fontSize = figmaFontSizeToSp(18f),
                lineHeight = figmaHeightToDp(24f).sp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
            )
        }*/
    }
}
