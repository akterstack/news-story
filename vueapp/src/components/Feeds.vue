<template>
  <!-- Configure "view" prop for QLayout -->
    <div class="layout-padding card-examples row items-start" style="width: 40%; text-align: left">
      <div v-for="story in stories">
        <q-card inline color="secondary">
          <q-card-title>
            {{story.title}}
            <span slot="subtitle">{{story.author.fullName}}</span>
          </q-card-title>
          <q-card-main>
            {{story.body}}
          </q-card-main>
          <q-card-separator />
          <q-card-actions>
            <q-btn flat @click="getStory( story.id )">HTML</q-btn>
            <q-btn flat @click="getStoryJSON( story.id )">JSON</q-btn>
          </q-card-actions>
        </q-card>
      </div>
    </div>
    <!-- Footer
    <q-toolbar slot="footer">
      ...
    </q-toolbar>
    -->
</template>

<script>
import {
  QCard,
  QCardTitle,
  QCardMain,
  QCardSeparator,
  QCardActions,
  QBtn
} from 'quasar'
export default {
  components: {
    QCard,
    QCardTitle,
    QCardMain,
    QCardSeparator,
    QCardActions,
    QBtn
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
    },

    getStory: function (storyId) {
      this.$router.push({name: 'news_detail', params: {id: storyId}})
    },

    getStoryJSON: function (storyId) {
      window.location.href = 'http://localhost:8080/api/stories/' + storyId
    }
  }
}
</script>

<style>
</style>
