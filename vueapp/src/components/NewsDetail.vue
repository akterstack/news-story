<template>
  <div class="layout-padding card-examples row items-start" style="width: 40%; text-align: left">
    <q-card inline color="secondary">
      <q-card-title>
        {{story.title}}
        <span slot="subtitle">{{story.author.fullName}} - {{story.publishedDate}}</span>
      </q-card-title>
      <q-card-main>
        {{story.body}}
      </q-card-main>
      <q-card-separator />
      <q-card-actions>
        <q-btn flat @click="back()">Back</q-btn>
      </q-card-actions>
    </q-card>
  </div>
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
  QBtn
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
    QBtn
  },
  data () {
    return {
      story: {
        author: {}
      }
    }
  },

  created: function () {
    this.getStory()
  },

  methods: {
    getStory: function () {
      this.$http.get('/stories/' + this.$route.params.id)
        .then(resp => {
          console.log(resp.data)
          this.story = resp.data
        })
    },

    back: function () {
      this.$router.go(-1)
    }
  }
}
</script>

<style>
</style>
