package com.example.tutorials
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Follow me in instagram",true),
            Todo("Learn about RecyclerView",true),
            Todo("Feed my cat",false),
            Todo("Prank my boss",true),
            Todo("Eat some curry",false),
            Todo("Ask my crush out",true),
            Todo("Take a shower",true)
        )

        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}