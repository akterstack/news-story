<template>
  <!-- Configure "view" prop for QLayout -->
  <q-layout>
    <q-toolbar slot="header">
      <!-- opens drawer below
      <button class="hide-on-drawer-visible" @click="$refs.drawer.open()">
        <i>menu</i>
      </button>
      -->
      <q-toolbar-title>
        <h6>News Today</h6>
      </q-toolbar-title>
    </q-toolbar>

    <div class="layout-padding card-examples row items-start" style="width: 40%; text-align: left">
      <div v-for="story in stories">
        <q-card inline color="secondary">
          <q-card-title>
            {{story.title}}
            <span slot="subtitle">{{story.author.fullName}}</span>
            <!-- <q-icon slot="right" name="alarm" /> -->
          </q-card-title>
          <q-card-main>
            {{story.body}}
          </q-card-main>
          <q-card-separator />
          <q-card-actions>
            <q-btn flat>Action 1</q-btn>
            <q-btn flat>Action 2</q-btn>
          </q-card-actions>
        </q-card>
      </div>
    </div>

    <router-view />

    <!-- Footer
    <q-toolbar slot="footer">
      ...
    </q-toolbar>
    -->
  </q-layout>
</template>

<script>
import {
  QLayout,
  QToolbar,
  QToolbarTitle,
  QCard,
  QCardTitle,
  QCardMain,
  QCardSeparator,
  QCardActions,
  QBtn,
  QIcon
} from 'quasar'
export default {
  components: {
    QLayout,
    QToolbar,
    QToolbarTitle,
    QCard,
    QCardTitle,
    QCardMain,
    QCardSeparator,
    QCardActions,
    QBtn,
    QIcon
  },
  data () {
    return {
      stories: []
    }
  },

  created: function () {
    this.fetchStories()
  },

  methods: {
    fetchStories: function () {
      this.$http.get('/stories')
        .then(resp => {
          console.log(resp.data)
          this.stories = resp.data.content
        })
    }
  }
}
</script>

<style>
</style>
