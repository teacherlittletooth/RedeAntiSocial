package br.com.redeantisocialtarde

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.redeantisocialtarde.ui.theme.RedeAntiSocialTardeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedeAntiSocialTardeTheme {
                //Aqui vai o código que será
                //lançado para o celular
            }
        }
    }
}

@Composable
fun PostUser(
    @DrawableRes image: Int,
    name: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Imagem de perfil",
            modifier = modifier
                .size(42.dp)
                .clip(CircleShape)
                .border(
                    width = 1.6.dp,
                    color = Color.Blue,
                    shape = CircleShape
                )
        )

        Spacer(
            modifier = modifier.padding(horizontal = 4.dp)
        )

        Column {
            Text(
                text = name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = time,
                color = Color.Gray
            )
        }
    }//Row
}//PostUser

@Composable
fun PostImage(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(260.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Foto da postagem",
            modifier = modifier.fillMaxSize()
        )
    }
}//PostImage

@Composable
fun PostIcons(
    like: Boolean,
    onChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row {
        IconButton(
            onClick = onChange
        ) {
            Icon(
                imageVector = if(like) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Ícone de curtida",
                tint = if(like) Color.Red else Color.Black
            )
        }

        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Ícone de comentário"
            )
        }
    }//Row
}//PostIcons

//Componente para controle de estado
@Composable
fun PostIconsState(
    modifier: Modifier = Modifier
) {
    var likeChange by remember {
        mutableStateOf(false)
    }

    PostIcons(
        like = likeChange,
        onChange = { likeChange = !likeChange }
    )
}

@Composable
fun PostText(
    text: String,
    modifier: Modifier = Modifier
) {
    Box {
        Text(text = text)
    }
}

@Composable
fun PostPage(
    @DrawableRes imageUser: Int,
    nameUser: String,
    timeUser: String,
    @DrawableRes imagePost: Int,
    textPost: String,
    modifier: Modifier = Modifier
) {
    Column {
        PostUser(
            image = imageUser,
            name = nameUser,
            time = timeUser
        )

        PostImage(
            image = imagePost
        )

        PostIconsState()

        PostText(
            text = textPost
        )
    }//Column
}

/////////////////////////////////////////////
@Preview(showBackground = true)
@Composable
fun PostUserPreview() {
    RedeAntiSocialTardeTheme {
        PostUser(
            image = R.drawable.ic_launcher_foreground,
            name = "Oswaldir Prado",
            time = "2 horas atrás"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostImagePreview() {
    RedeAntiSocialTardeTheme {
        PostImage(image = R.drawable.ic_launcher_background)
    }
}

@Preview(showBackground = true)
@Composable
fun PostIconsPreview() {
    RedeAntiSocialTardeTheme {
        PostIconsState()
    }
}

@Preview(showBackground = true)
@Composable
fun PostPagePreview() {
    RedeAntiSocialTardeTheme {
        PostPage(
            imageUser = R.drawable.ic_launcher_foreground,
            nameUser = "Chin Zuang",
            timeUser = "3 minutos atrás",
            imagePost = R.drawable.ic_launcher_background,
            textPost = "Fotos da viagem à marte!"
        )
    }
}
