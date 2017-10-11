<template>
  <!-- Don't drop "q-app" class -->
  <div id="q-app">
    <header></header>
    <main>  
      <q-layout>
        <q-toolbar slot="header">
          <q-toolbar-title>
            <h6>News Today</h6>
          </q-toolbar-title>
        </q-toolbar>
        <router-view></router-view>
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
  QToolbarTitle
} from 'quasar'
export default {
  components: {
    QLayout,
    QToolbar,
    QToolbarTitle
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
