package com.artemissoftware.orpheusplayer.presentation.composables.player

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PlayerIcon(
    icon: ImageVector,
    border: BorderStroke? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    color: Color = MaterialTheme.colorScheme.onSurface,
) {
    Surface(
        shape = CircleShape,
        border = border,
        modifier = modifier
            .clip(CircleShape)
            .clickable {
                onClick.invoke()
            },
        contentColor = color,
        color = backgroundColor,

    ) {
        Box(
            modifier = Modifier.padding(4.dp),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlayerIconPreview() {
    PlayerIcon(
        icon = Icons.Default.Add,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onSurface,
        ),
        onClick = {},
    )
}
