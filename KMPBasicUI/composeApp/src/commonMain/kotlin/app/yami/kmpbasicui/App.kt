package app.yami.kmpbasicui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kmpbasicui.composeapp.generated.resources.Res
import kmpbasicui.composeapp.generated.resources.profile
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .safeContentPadding()
                .fillMaxSize().
            verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.size(50.dp))
            Image(
                painter = painterResource(Res.drawable.profile),
                modifier = Modifier.size(150.dp).clip(CircleShape)
                    .border(width = 2.dp, color = Color.LightGray, shape = CircleShape),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(50.dp))
            CustomTextField(
                imageVector = Icons.Default.AccountCircle,
                hintText = "Enter Name",
                labelText = "Name",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(15.dp))
            CustomTextField(
                imageVector = Icons.Default.Mail,
                hintText = "Enter Email",
                labelText = "Email",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(15.dp))
            CustomTextField(
                imageVector = Icons.Default.Phone,
                hintText = "Enter Mobile No.",
                labelText = "Mobile No.",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(15.dp))
            DropDown()
            Spacer(modifier = Modifier.size(15.dp))
            Text("Sex:", modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold)
            RadioGroup()
            Spacer(modifier = Modifier.size(15.dp))
            Text("Hobbies:", modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold)
            CheckBoxGroup()
            Spacer(modifier = Modifier.size(40.dp))
            ElevatedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { println("Registration success!!!") },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Register", modifier = Modifier.padding(10.dp))
            }

        }
    }
}

@Composable
fun CustomTextField(
    imageVector: ImageVector? = null,
    hintText: String? = null,
    labelText: String?,
    modifier: Modifier
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text(labelText ?: "") },
        placeholder = { Text(hintText ?: "") },
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        leadingIcon = {
            imageVector?.let {
                Icon(
                    imageVector = it,
                    contentDescription = ""
                )
            }
        }
    )
}

@Composable
fun RadioGroup() {
    val options = arrayOf("Male", "Female")
    var selectedOption by remember { mutableStateOf(options[0]) }
    Row(modifier = Modifier.fillMaxWidth()) {
        options.forEach { option ->
            RadioButton(
                selected = (option == selectedOption),
                onClick = { selectedOption = option }
            )
            Text(
                text = option,
                modifier = Modifier.padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.padding(15.dp))
        }

    }
}

@Composable
fun CheckBoxGroup() {
    val options = arrayOf("Books", "Travel", "Movies")
    val checkedStatus = remember { mutableStateListOf(false, false, false, false, false) }
    options.forEachIndexed { index, option ->
        Row(modifier = Modifier.fillMaxWidth()) {
            Checkbox(
                checked = checkedStatus[index],
                onCheckedChange = { checkedStatus[index] = it })
            Text(
                text = option,
                modifier = Modifier.padding(top = 10.dp)
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(){
    val options = arrayOf("India", "Singapore", "Malaysia", "China", "Korea", "SriLanka" )
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        modifier = Modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }) {
        TextField(
            modifier = Modifier.fillMaxWidth().menuAnchor(MenuAnchorType.PrimaryNotEditable),
            value = selectedOption,
            readOnly = true,
            onValueChange = {},
            label = {
                Text(text="Country")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
            },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White)
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false},
            modifier = Modifier.fillMaxWidth().background(Color.White)
        ){
            options.forEachIndexed { index, data ->
                DropdownMenuItem(
                    onClick = {
                        selectedOption = data
                        expanded = false
                    },
                    text = {Text(data)}
                )
            }
        }
    }
}