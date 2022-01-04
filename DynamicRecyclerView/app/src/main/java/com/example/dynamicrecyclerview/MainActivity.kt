package com.example.dynamicrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dynamicrecyclerview.databinding.ActivityMainBinding

//공부한 곳 https://android-dev.tistory.com/41

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val friendModelList = ArrayList<SectionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadFakeData()
    }

    private fun loadFakeData(){
        val firstCategory = "고등학교"
        val firstFriends = ArrayList<Friend>()
        firstFriends.add(Friend("이순신", 32, "010-1234-1111"))
        firstFriends.add(Friend("홍길동", 13, "010-1234-1112"))
        firstFriends.add(Friend("강감찬", 13, "010-1234-1113"))
        firstFriends.add(Friend("연개소문", 13, "010-1234-1114"))

        val secondCategory = "대학교"
        val secondFriends = ArrayList<Friend>()
        secondFriends.add(Friend("머스크", 24, "010-1234-1115"))
        secondFriends.add(Friend("빌게이츠", 44, "010-1234-1116"))
        secondFriends.add(Friend("워렌버핏", 55, "010-1234-1117"))

        val thirdCategory = "직장"
        val thirdFriends = ArrayList<Friend>()
        thirdFriends.add(Friend("이재용", 45, "010-1234-1118"))
        thirdFriends.add(Friend("손흥민", 32, "010-1234-1119"))
        thirdFriends.add(Friend("김연아", 55, "010-1234-1120"))
        thirdFriends.add(Friend("손연재", 37, "010-1234-1121"))
        thirdFriends.add(Friend("정우성", 42, "010-1234-1122"))
        thirdFriends.add(Friend("손아섭", 41, "010-1234-1123"))

        friendModelList.add(SectionModel(firstCategory, firstFriends))
        friendModelList.add(SectionModel(secondCategory, secondFriends))
        friendModelList.add(SectionModel(thirdCategory, thirdFriends))
    }

    private fun setupRecyclerView() {
        binding.rvFriend.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = FriendAdapter(friendModelList)
        }
    }
}