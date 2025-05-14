package br.com.redeantisocialtarde.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.redeantisocialtarde.ListPost
import br.com.redeantisocialtarde.MyBottomBar
import br.com.redeantisocialtarde.MyTopBar
import br.com.redeantisocialtarde.PostPage
import br.com.redeantisocialtarde.ui.theme.RedeAntiSocialTardeTheme

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        containerColor = Color(167, 229, 129, 255),
        topBar = { MyTopBar() },
        bottomBar = { MyBottomBar() }
    ) {
        ListPost(
            modifier = modifier.padding(it)
        )
    }
}

////////////////////////////////////////////////////////
@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    RedeAntiSocialTardeTheme {
        FeedScreen()
    }
}
