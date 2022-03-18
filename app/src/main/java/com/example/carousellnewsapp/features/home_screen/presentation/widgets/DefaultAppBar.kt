package com.example.carousellnewsapp.features.home_screen.presentation.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.example.carousellnewsapp.R
import com.example.carousellnewsapp.core.eums.Action

@Composable
fun GetDefaultAppBar(
    onSortActionClicked: (Action) -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.AppBarTitle),
                style = MaterialTheme.typography.h6
            )
        },
        actions = {
            GetDefaultAppBarActions(
                onSortActionClicked = onSortActionClicked
            )
        },
    )
}

@Composable
fun GetDefaultAppBarActions(
    onSortActionClicked: (Action) -> Unit,
) {
    GetSortActionButton(onSortActionClicked = onSortActionClicked)
}

@Composable
fun GetSortActionButton(
    onSortActionClicked: (Action) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true }
    )
    {
        Icon(
            imageVector = Icons.Filled.MoreHoriz,
            contentDescription = "Option to sort the news list",
        )
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            expanded = false
        },
    ) {
        DropdownMenuItem(
            onClick = {
                expanded = false
                onSortActionClicked(Action.Recent)
            },
        ) {
            GetSortActionItem(Action.Recent)
        }
        DropdownMenuItem(
            onClick = {
                expanded = false
                onSortActionClicked(Action.Popular)
            },
        ) {
            GetSortActionItem(Action.Popular)
        }
    }
}

@Composable
fun GetSortActionItem(action: Action) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(action.name)
    }
}