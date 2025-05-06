package br.qi.socialmediatarde

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.qi.socialmediatarde.model.PostData
import br.qi.socialmediatarde.ui.theme.SocialMediaTardeTheme

@Composable
fun ListPost(
    list: List<PostData> = List(10) { PostData() },
    modifier: Modifier = Modifier
) {
    LazyColumn(
        state = LazyListState()
    ) {
        items(list) {
            Surface(
                modifier = modifier.padding(8.dp)
            ) {
                PostPage(
                    imageProfile = it.imageProfile,
                    nameProfile = it.nameProfile,
                    timeProfile = it.timeProfile,
                    imagePost = it.imagePost,
                    textPost = it.textPost,
                )
            }
        }
    }
}

///////////////////////////////////////////////
@Preview(
    showBackground = true,
    heightDp = 400
)
@Composable
fun ListPostPreview() {
    SocialMediaTardeTheme {
        ListPost()
    }
}
