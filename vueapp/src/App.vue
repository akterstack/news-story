<template>
  <!-- Don't drop "q-app" class -->
  <div id="q-app">
    <header></header>
    <main>  
      <q-layout>
        <q-toolbar slot="header">
          <q-toolbar-title>
            <q-btn flat class="header-title" @click="routeToRoot()">News Today</q-btn>
          </q-toolbar-title>
        </q-toolbar>
        <router-view></router-view>
        <q-fixed-position corner="bottom-right" :offset="[16, 16]">
          <q-fab
            ref="createstory"
            color="primary"
            direction="up"
            class="animate-pop"
            @open="renderCreateForm()"
            @close="removeCreateForm()"
          >
          </q-fab>
        </q-fixed-position>
      </q-layout>
    </main>
  </div>
</template>

<script>
/*
 * Root component
 */
import {
  QLayout,
  QToolbar,
  QToolbarTitle,
  QFab,
  QFabAction,
  QTooltip,
  QBtn,
  QFixedPosition,
  Dialog,
  Toast
} from 'quasar'
export default {
  components: {
    QLayout,
    QToolbar,
    QToolbarTitle,
    QFab,
    QFabAction,
    QTooltip,
    QBtn,
    QFixedPosition,
    Dialog,
    Toast
  },

  methods: {
    routeToRoot () {
      this.$router.push({name: 'feeds'})
    },
    renderCreateForm () {
      this.$router.push({name: 'create_news'})
    },

    removeCreateForm () {
      this.$router.go(-1)
    }
  }
}
</script>

<style lang="stylus">
@import '~variables'

main
  text-align center
  margin-top 0px

header
  margin 0
  height 10px
  background-color $primary
</style>
