package com.artemissoftware.orpheusplayer.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.orpheusplaylist.playaudio.data.models.Audio

@Composable
fun AudioItem(
    audio: Audio,
    onItemClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = MaterialTheme.colorScheme.surface.copy(alpha = .5f))
            .clickable {
                onItemClick.invoke()
            },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.size(70.dp).weight(0.5f),
                bitmap = audio.albumArt.asImageBitmap(),
                contentDescription = "Cover Photo",
            )

            Column(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp),
            ) {
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = audio.fileName(),
                    style = MaterialTheme.typography.headlineMedium,
                    overflow = TextOverflow.Clip,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = audio.artistName(),
                    style = MaterialTheme.typography.displayMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Clip,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .5f),
                )
            }
            Text(text = audio.timeStampToDuration())
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AudioItemPreview() {
    AudioItem(
        onItemClick = {},
        audio = DummyAudio.audioList[0],
    )
}
