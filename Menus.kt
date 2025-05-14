package br.com.redeantisocialtarde

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.redeantisocialtarde.ui.theme.RedeAntiSocialTardeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    title: String = "Título",
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        actions = {
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = "Ícone menu"
                )
            }
        }

    )
}

@Composable
fun MyBottomBar(
    color: Color = Color.Black,
    colorSelected: Color = Color.Gray,
    size: Dp = 30.dp,
    sizeSelected: Dp = 40.dp,
    modifier: Modifier = Modifier
) {
    var itemSelected by remember {
        mutableStateOf(0)
    }

    BottomAppBar {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { itemSelected = 0 }
            ) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Ícone perfil",
                    tint = if(itemSelected==0) colorSelected else color,
                    modifier = modifier
                        .animateContentSize()
                        .size(if(itemSelected==0) sizeSelected else size)
                )
            }

            IconButton(
                onClick = { itemSelected = 1 }
            ) {
                Icon(
                    imageVector = Icons.Outlined.AddCircle,
                    contentDescription = "Ícone novo post",
                    tint = if(itemSelected==1) colorSelected else color,
                    modifier = modifier
                        .animateContentSize()
                        .size(if(itemSelected==1) sizeSelected else size)
                )
            }

            IconButton(
                onClick = { itemSelected = 2 }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "Ícone configurações",
                    tint = if(itemSelected==2) colorSelected else color,
                    modifier = modifier
                        .animateContentSize()
                        .size(if(itemSelected==2) sizeSelected else size)
                )
            }
        }
    }//BottomAppBar
}


///////////////////////////////////////////////////////
@Preview(showBackground = true)
@Composable
fun MyTopBarPreview() {
    RedeAntiSocialTardeTheme {
        MyTopBar(title = "Início")
    }
}

@Preview(showBackground = true)
@Composable
fun MyBottomBarPreview() {
    RedeAntiSocialTardeTheme {
        MyBottomBar()
    }
}

