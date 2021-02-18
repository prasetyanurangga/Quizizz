package com.prasetyanurangga.quizizz.ui

import com.prasetyanurangga.quizizz.data.model.QuestionModel
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup


class Question(title: String?, items: List<QuestionModel?>?) : ExpandableGroup<QuestionModel?>(title, items)