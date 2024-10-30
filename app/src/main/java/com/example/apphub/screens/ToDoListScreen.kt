package com.example.apphub.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apphub.viewmodel.ToDoViewModel

@Composable
fun ToDoListScreen(viewModel: ToDoViewModel = viewModel()) { // Correct type here
    var textState by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TextField for input
        TextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("Add a new task") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Button to add new task
        Button(
            onClick = {
                if (textState.text.isNotBlank()) {
                    viewModel.addItem(textState.text)
                    textState = TextFieldValue("") // Clear input after adding
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn for displaying to-do items
        LazyColumn {
            items(viewModel.todoItems.size) { index ->
                ToDoItem(task = viewModel.todoItems[index], onDelete = { viewModel.removeItem(it) })
            }
        }
    }
}

@Composable
fun ToDoItem(task: String, onDelete: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = task,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { onDelete(task) }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete Task"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewToDoListScreen() {
    // Mock data for preview
    val mockViewModel = ToDoViewModel().apply {
        addItem("Sample Task 1")
        addItem("Sample Task 2")
        addItem("Sample Task 3")
    }
    ToDoListScreen(viewModel = mockViewModel)
}