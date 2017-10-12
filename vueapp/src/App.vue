<template>
  <!-- Don't drop "q-app" class -->
  <div id="q-app">
    <header></header>
    <main>  
      <q-layout>
        <q-toolbar slot="header">
          <q-toolbar-title>
            <h6 class="header-title"><a href="/" style="color: white">News Today</a></h6>
          </q-toolbar-title>
        </q-toolbar>
        <router-view></router-view>
        <q-fixed-position corner="bottom-right" :offset="[560, 16]">
          <q-fab
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
    renderCreateForm () {
      this.$router.push({name: 'create_news'})
    },

    removeCreateForm () {
      this.$router.push({name: 'feeds'})
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
