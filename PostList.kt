package br.com.redeantisocialtarde

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.redeantisocialtarde.model.PostData
import br.com.redeantisocialtarde.ui.theme.RedeAntiSocialTardeTheme

@Composable
fun ListPost(
    list: Array<PostData> = listagem,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(list) {
            PostPage(
                imageUser = it.imageUser,
                nameUser = it.nameUser,
                timeUser = it.timeUser,
                imagePost = it.imagePost,
                textPost = it.textPost
            )
        }
    }
}

//////////////////////////////////////////////
@Preview(
    showBackground = true,
    heightDp = 400
)
@Composable
fun ListPostPreview() {
    RedeAntiSocialTardeTheme {
        ListPost()
    }
}

/////////////////////////////////////////////////////////

val listagem = arrayOf<PostData>(
    PostData(
        imageUser = R.drawable.chaves_profile,
        nameUser = "Chaves",
        timeUser = "3 minutos atrás",
        imagePost = R.drawable.chaves_post,
        textPost = "Se você é jovem ainda..."
    ),

    PostData(
        //imageUser = R.drawable.chaves_profile,
        nameUser = "Kiko",
        timeUser = "1 minuto atrás",
        //imagePost = R.drawable.chaves_post,
        textPost = "Você não vai com a minha cara?"
    ),
)
