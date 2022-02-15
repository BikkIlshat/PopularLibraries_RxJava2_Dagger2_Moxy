package com.hfad.popularlibrariesrxjava2dagger2moxy

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubUsersRepo
import com.hfad.popularlibrariesrxjava2dagger2moxy.presentation.UserPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.Schedulers
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class UserPresenterTest {

  private lateinit var presenter: UserPresenter

  @InjectMocks
  private lateinit var userLogin: String

  @Mock
  private lateinit var gitHubRepo: GithubUsersRepo

  @Mock
  private lateinit var schedulers: Schedulers


  @Mock
  private lateinit var router: Router


  @Before
  fun setUp() {
    MockitoAnnotations.initMocks(this)
    presenter = UserPresenter(userLogin, gitHubRepo, schedulers, router)
  }

  @Test
  fun userPresenterBackClick_Test() {
    presenter.backClick()
    verify(gitHubRepo, times(1))
  }


}