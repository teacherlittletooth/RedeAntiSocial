package br.qi.socialmedianoite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.qi.socialmedianoite.model.PostData
import br.qi.socialmedianoite.ui.theme.SocialMediaNoiteTheme

@Composable
fun ListPost(
    list: List<PostData> = List(10) { PostData(nameProfile = "Usuário $it") },
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(list) {
            Surface(
                modifier = modifier.padding(10.dp)
            ) {
                PostPage(
                    imageProfile = it.imageProfile,
                    nameProfile = it.nameProfile,
                    timeProfile = it.timeProfile,
                    imagePost = it.imagePost,
                    textPost = it.textPost
                )
            }
        }
    }
}

///////////////////////////////////////////
@Preview(
    showBackground = true,
    heightDp = 400
)
@Composable
fun ListPostPreview() {
    SocialMediaNoiteTheme {
        ListPost()
    }
}
